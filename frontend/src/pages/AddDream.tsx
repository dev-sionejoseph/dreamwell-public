import { useState } from "react";

import { Link, useNavigate } from "react-router-dom";



export default function AddDream() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [dreamDate, setDreamDate] = useState("");

  const userId = "568a6de8-2b5d-44da-81d3-0e02bbe43fa6";
  const navigate = useNavigate();
  const apiUrl = import.meta.env.VITE_API_URL;

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    const dream = { title, description, dreamDate, userid: userId };

    const res = await fetch(`${apiUrl}/api/dreams`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(dream),
    });

    if (res.ok) {
      navigate("/");
    } else {
      alert("Failed to create dream.");
    }
  };

  return (
    <div className="p-6">
        <Link
          to="/"
          className="inline-block bg-palegreen text-navy px-4 py-2 rounded mb-4">
          &lt;
        </Link>
      <h1 className="text-2xl text-lavender mb-4">Add a New Dream</h1>

      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          type="text"
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          className="w-full p-2 rounded text-navy"
          required
        />

        <textarea
          placeholder="Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          className="w-full p-2 rounded text-navy"
          required
        />

        <input
          type="date"
          value={dreamDate}
          onChange={(e) => setDreamDate(e.target.value)}
          className="w-full p-2 rounded text-navy"
          required
        />

        <button
          type="submit"
          className="bg-palegreen text-navy px-4 py-2 rounded"
        >
          Save Dream
        </button>
      </form>
    </div>
  );
}

