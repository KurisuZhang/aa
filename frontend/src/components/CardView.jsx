import CardDefault from "./CardDefault.jsx";

const CardView = ({ products }) => {
  return (
    <div>
      <div className="mt-3 flex flex-wrap justify-center">
        {products.map((product) => (
          <CardDefault
            key={product.id} // Add a unique key when rendering a list
            image={product.image}
            title={product.title}
            price={product.price}
          />
        ))}
      </div>
    </div>
  );
};

export default CardView;
