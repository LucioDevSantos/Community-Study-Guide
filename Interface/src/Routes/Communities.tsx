
import CommunityIcon from "../Components/CommunityIcon"

type Community = {
    id: number,
    name:string,
    
}

export default function Communities(){




const data = {
    name: "test",
    code: 2453
}

    return(
        <>
        <div className="bg-slate-700 w-screen h-full ">
        <CommunityIcon name={data.name} code={data.code}/>
        </div>
        </>
    )
}


