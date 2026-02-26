// 1. POST
const func = async () => {
    try {
        const data = {
            "studentName": "홍길동",
            "date": "2026-02-26",
            "status": "출석"
        };
        const response = await axios.post("/attendance", data);
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}

// 2. GET
const func1 = async () => {
    try {
        const response = await axios.get("/attendance");
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}

// 3. GET
const func2 = async () => {
    try {
        const response = await axios.get("/attendance/detail?ano=1");
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}

// 4. DELETE
const func3 = async () => {
    try {
        const response = await axios.delete("/attendance?ano=1");
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}

// 5. PUT
const func4 = async () => {
    try {
        const data = {
            "ano": 1,
            "status": "지각"
        };
        const response = await axios.put("/attendance", data);
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}
