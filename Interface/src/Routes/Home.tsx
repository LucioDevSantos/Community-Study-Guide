import { useEffect, useState } from "react";
import CommunityIcon from "../Components/CommunityIcon";
import { apiSpring } from "../Services/api";
import CommunityModel from "../Interfaces/CommunityModel";
import Header from "../Components/Header";

export const CommunityUrl = "/community";

export default function Home() {
  const [coms, setComs] = useState<CommunityModel[] | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const getData = async () => {
      try {
        const response = await apiSpring.get<CommunityModel[]>(
          `${CommunityUrl}/`,
        );
        setComs(response.data);
      } catch (err) {
        setError(err instanceof Error ? err.message : "Unknown Error");
      } finally {
        setLoading(false);
      }
    };
    getData();
  }, []);

  if (loading) {
    return <div>Carregando...</div>;
  }

  if (error) {
    return <div>{`Erro: ${error}`}</div>;
  }

  return (
    <>
      <div
        className="bg-slate-700
        h-screen "
      >
        <Header />
        {coms?.map((community) => (
          <CommunityIcon
            key={community.id}
            name={community.name}
            code={community.code}
            id={community.id}
          />
        ))}
      </div>
    </>
  );
}
