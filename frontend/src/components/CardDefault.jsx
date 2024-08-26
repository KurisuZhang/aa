export function CardDefault({ image, title, price }) {
  return (
    <div className="relative m-5 flex w-9/12 max-w-xs flex-col overflow-hidden rounded-lg border border-gray-100 bg-white shadow-md">
      <a
        className="relative mx-auto mt-3 flex h-60 overflow-hidden rounded-xl"
        href="#"
      >
        <img className="object-cover" src={image} alt="product image" />
      </a>
      <div className="mt-4 px-5 pb-5">
        <a href="#">
          <h5 className="text-slate-900 text-center text-xl tracking-tight">
            {title}
          </h5>
        </a>
        <div className="mb-5 mt-2 flex items-center justify-center">
          <p>
            <span className="text-slate-900 text-3xl font-bold">${price}</span>
            {/*<span className="text-sm text-slate-900 line-through">$699</span>*/}
          </p>
        </div>
        <a
          href="#"
          className="flex items-center justify-center rounded-md bg-gray-700 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-gray-900 focus:outline-none focus:ring-4 focus:ring-blue-300"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="mr-2 h-6 w-6"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            strokeWidth="2"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"
            />
          </svg>
          Add to cart
        </a>
      </div>
    </div>
  );
}

export default CardDefault;
