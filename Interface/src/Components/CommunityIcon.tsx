import { Link } from "react-router-dom"


type data = {
    name:string,
    code:number
}




export default function CommunityIcon(data: data){
    return(
        <>
        <div className="bg-blue-800 rounded-lg flex  ">
            {data.name}

            <button className="m-10 ">
                
             <Link to={`/community/${data.code}`} state={{comData: data}}>Enter</Link>   
            </button>
        </div>
        </>
    )
}
