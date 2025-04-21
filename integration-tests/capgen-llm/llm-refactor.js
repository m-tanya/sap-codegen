const fs = require("fs");
const path = require("path");
require('dotenv').config({ path: './integration-tests/capgen-llm/.env' });

const axios = require("axios");

const OPENROUTER_KEY = process.env.OPENROUTER_KEY;
if (!OPENROUTER_KEY) {
  throw new Error("OPENROUTER_KEY is missing! Check your .env file.");
}

const MCP_BASE = "http://localhost:5050";

const SUMMARY_FILE = "generated_summary.txt";
const JAVA_FILE = "src/main/java/TestRun.java";
const MODEL="nvidia/llama-3.3-nemotron-super-49b-v1:free";

async function readFromMCP(path) {
    console.log(` updated path: ${path}`);
  const res = await axios.get(`${MCP_BASE}/read`, { params: { path } });
  return res.data.content;
}

async function writeToMCP(path, content) {;
  console.log(` updated content: ${content}`);
  await axios.post(`${MCP_BASE}/write`, { path, content });
  console.log(`Wrote updated content to: ${path}`);
}

async function sendToLLM(summary) {
  const prompt = `
You are a Java backend developer. Below is a summary of an existing class named TestRun:

${summary}

 Your task:
- Add a new public method named \`subtract\` that takes two integers and returns their difference.
- Make sure the method is added in the appropriate place in the Java file.
- Return the entire, updated Java class code.

Only output valid, complete Java code with proper formatting.
`;

  const res = await axios.post("https://openrouter.ai/api/v1/chat/completions", {
    model: MODEL,
    messages: [{ role: "user", content: prompt }]
  }, {
    headers: {
      Authorization: `Bearer ${OPENROUTER_KEY}`,
      "HTTP-Referer": "http://localhost",
      "X-Title": "capgen-nemotron-refactor"
    }
  });

  return res.data.choices[0].message.content;
}

async function main() {
  try {
    console.log("Reading summary from MCP...");
    if(OPENROUTER_KEY){
        console.log("Got key!");
    }
    const summary = await readFromMCP(SUMMARY_FILE);

    console.log("Sending prompt to Llama (Nemotron)...");
    const updatedCode = await sendToLLM(summary);

    console.log("Writing updated Java class back via MCP...");
    await writeToMCP(JAVA_FILE, updatedCode);

    console.log("Done! Check ${JAVA_FILE} for the update.");
  } catch (err) {
    console.error("Full Error:", err);
  
    if (err.response) {
      console.error("API Error:", err.response.status);
      console.error("Response Data:", err.response.data);
    } else if (err.request) {
      console.error("No response received:", err.request);
    } else {
      console.error("General Error:", err.message);
    }
  }
  
}

main();
