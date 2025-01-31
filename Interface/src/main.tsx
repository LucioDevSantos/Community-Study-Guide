import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import CreateQuestion from "./Routes/CommunityRoutes/Questions/CreateQuestion.tsx";
import Questions from "./Routes/Questions.tsx";
import QuestionsAll from "./Routes/AllQuestions.tsx";
import ErrorPage from "./Routes/ErrorHandle/ErrorPage.tsx";
import Community from "./Routes/CommunityRoutes/Community.tsx";
import Home from "./Routes/Home.tsx";
import CommunityCreate from "./Routes/CommunityRoutes/CommunityCreate.tsx";
import CommunityChat from "./Routes/CommunityRoutes/communityChat.tsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/questions",
    element: <QuestionsAll />,
  },
  // {
  //   path: "/create",
  //   element: <CreateQuestion/>
  // },
  {
    path: "/**",
    element: <ErrorPage />,
  },
  {
    path: "/community/:id",
    element: <Community />,
    children: [
      {
        path: "questions",
        element: <Questions />,
      },
      {
        path: "createQuestion",
        element: <CreateQuestion />,
      },
      {
        path: "chat",
        element: <CommunityChat />,
      },
    ],
  },

  {
    path: "/community/create",
    element: <CommunityCreate />,
  },
]);

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
);
