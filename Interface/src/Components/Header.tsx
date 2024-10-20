import { Link } from "react-router-dom"
import "../index.css"
import "../styles/main.css"
import { Plus } from "lucide-react"

export default function Header(){
    return(

        <>

            <nav className="w-full h-1/6 bg-blue-700 flex flex-row items-end ">
                <ul className="flex flex-row justify-between h-full">
                <li>Topics</li>
                <li>My Questions</li>
                <li className="bg-green-800 rounded-full p-2 text-center flex items-center ">
                <Link to={"/create"}>
                <Plus></Plus>
                </Link></li>
                </ul>


            </nav>




        </> 

    )

}