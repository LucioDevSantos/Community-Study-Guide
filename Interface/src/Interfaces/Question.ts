type Question = {
    id?: number
    content: string,
    topic?: string,
    options: Option[]
}

type Option = {
    id?: number
    name?: string,
    content: string,
    isRight: boolean
}


export default Question
