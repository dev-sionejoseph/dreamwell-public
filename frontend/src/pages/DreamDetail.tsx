import { useEffect, useState } from "react";

import { Link, useNavigate, useParams } from "react-router-dom";

interface Dream {
  id: string;
  title: string;
  description: string;
  dreamDate: string;
}

export default function DreamDetail() {
  const { id } = useParams();
  const [dream, setDream] = useState<Dream | null>(null);
  const navigate = useNavigate();
  const apiUrl = import.meta.env.VITE_API_URL;

  useEffect(() => {
    fetch(`${apiUrl}/api/dreams/${id}`)
      .then((res) => res.json())
      .then(setDream);
  }, [id]);

  const handleDelete = async () => {
    const res = await fetch(`/api/dreams/${id}`, { method: "DELETE" });

    if (res.ok) navigate("/");
    else alert("Failed to delete.");
  };

  if (!dream) return <p className="p-6">Loading...</p>;

  return (
    <div className="p-6">
      <Link
          to="/"
          className="inline-block bg-palegreen text-navy px-4 py-2 rounded mb-4">
          &lt;
        </Link>
      <h1 className="text-3xl text-lavender mb-2">{dream.title}</h1>
      <p className="mb-4 text-sm text-palegreen">{dream.dreamDate}</p>
      <p className="mb-6">{dream.description}</p>

      <button
        onClick={handleDelete}
        className="bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700"
      >
        x
      </button>
    </div>
  );
}
