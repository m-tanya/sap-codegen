const express = require("express");
const fs = require("fs");
const path = require("path");
const { exec } = require("child_process");

const app = express();
const PORT = 5050;

app.use(express.json());

const ROOT = path.resolve(__dirname, ".."); // adjust based on project structure

// Read file content
app.get("/read", (req, res) => {
  const filePath = path.join(ROOT, req.query.path);
  fs.readFile(filePath, "utf8", (err, data) => {
    if (err) {
      console.error("❌ File read error:", err.message);
      return res.status(500).send(err.message);
    }
    res.send({ content: data });
  });
});

// Write content to file
app.post("/write", (req, res) => {
  const filePath = path.join(ROOT, req.body.path);
  fs.writeFile(filePath, req.body.content, "utf8", (err) => {
    if (err) {
      console.error("❌ File write error:", err.message);
      return res.status(500).send(err.message);
    }
    res.send({ status: "✅ File written" });
  });
});

// Run a shell command (e.g., mvn compile)
app.post("/run", (req, res) => {
  const command = req.body.command;
  exec(command, { cwd: ROOT }, (err, stdout, stderr) => {
    if (err) {
      console.error("❌ Command error:", stderr);
      return res.status(500).send(stderr);
    }
    res.send({ output: stdout });
  });
});

app.listen(PORT, () => {
  console.log(`🚀 MCP server running at http://localhost:${PORT}`);
});
