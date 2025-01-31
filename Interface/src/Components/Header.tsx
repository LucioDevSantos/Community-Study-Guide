import { Link } from "react-router-dom";
import "../index.css";
import "../styles/main.css";
import { Plus } from "lucide-react";
import { ChangeEvent, useState } from "react";
import Question from "../Interfaces/Question";

export default function Header() {

  const [content, setContent] = useState('')
  const [result, setResult] = useState<Question>()

  


  const handleChange = (e: ChangeEvent<HTMLInputElement>): void => {
      setContent(e.target.value)
  }


  const handleSearch = () => {
    console.log(content)


  }


  return (
    <>
      <nav className="w-full h-1/6 bg-blue-700 flex flex-row items-center justify-center">
      <input type="text" className="w-1/3 h-1/3 px-2 border-black border-2 border-r-0 rounded-sm rounded-r-none " onChange={handleChange}/>
      <button className="bg-slate-100 h-1/3 px-2 border-black border-2 rounded rounded-l-none " onClick={handleSearch}>Search</button>
      
      </nav>


    </>
  );
}
