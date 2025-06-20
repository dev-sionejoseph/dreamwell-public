import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

interface Dream {
    id:string;
    title: string;
    dreamDate: string;
}

export default function Dashboard() {
    const [dreams, setDreams] = useState<Dream[]>([]);
    const apiUrl = import.meta.env.VITE_API_URL;
    const userId = "6d46d592-e27d-4245-8771-0c7bba3cc925";

    useEffect(()=> {
        const fetchDreams = async () => {
            try{
                const response = await fetch(`${apiUrl}/api/dreams/user/${userId}`);
                const data = await response.json();
                setDreams(data)
            } catch (err) {
                console.error("Failed to fetch dreams")
            }
            
        }
        fetchDreams();
    }, [])

    return (
      <div className="p-6">
        <h1 className="text-3xl mb-6 text-lavender">Your Dreams</h1>

        <Link
          to="/add"
          className="inline-block bg-palegreen text-navy px-4 py-2 rounded mb-4">
          +
        </Link>

        <ul className="space-y-4 mt-4">
          {dreams.map((dream) => (
            <li key={dream.id}>
              <Link
                to={`/dreams/${dream.id}`}
                className="block p-4 bg-white text-navy rounded shadow hover:bg-lavender"
              >
                <h2 className="text-xl font-semibold">{dream.title}</h2>

                <p className="text-sm">{dream.dreamDate}</p>
              </Link>
            </li>
          ))}
        </ul>
      </div>
    );
}