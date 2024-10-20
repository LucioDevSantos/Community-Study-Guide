import { useLocation, useParams } from "react-router-dom"




export default function Community(){

const { id } = useParams()
const locateData = useLocation()

const {comData} = locateData.state || {}
    
    return(
        <>
        
        <div>
            <h4>
                id: {id}
            </h4>
            <header>
                <h1>
                    {comData.name}
                </h1>
            <p>
                {comData.code}
            </p>


            </header>
        </div>
        </>
    )
}