import { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../components/MyNavbar.jsx";
import MyCarousel from "../components/MyCarousel.jsx";
import CardView from "../components/CardView.jsx";

const Home = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetchedData("https://fakestoreapi.com/products");
  }, []);

  function fetchedData(url) {
    axios
      .get(url)
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the products!", error);
      });
  }

  return (
    <>
      <Navbar setProducts={setProducts}></Navbar>
      <MyCarousel></MyCarousel>
      <CardView products={products}> </CardView>
    </>
  );
};

export default Home;
