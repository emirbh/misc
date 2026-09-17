package fpml.consolidated.asset;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.asset.meta.UnderlyerMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the whole set of possible underlyers: single underlyers or multiple underlyers, each of these having either security or index components.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the whole set of possible underlyers: single underlyers or multiple underlyers, each of these having either security or index components.
 *
 */
@RosettaDataType(value="Underlyer", builder=Underlyer.UnderlyerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Underlyer", model="fpml", builder=Underlyer.UnderlyerBuilderImpl.class, version="2.1.1")
public interface Underlyer extends RosettaModelObject {

	UnderlyerMeta metaData = new UnderlyerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the swap's underlyer when it has only one asset component.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the swap's underlyer when it has only one asset component.
	 *
	 */
	SingleUnderlyer getSingleUnderlyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the swap's underlyer when it has multiple asset components.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the swap's underlyer when it has multiple asset components.
	 *
	 */
	Basket getBasket();

	/*********************** Build Methods  ***********************/
	Underlyer build();
	
	Underlyer.UnderlyerBuilder toBuilder();
	
	static Underlyer.UnderlyerBuilder builder() {
		return new Underlyer.UnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Underlyer> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Underlyer> getType() {
		return Underlyer.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("singleUnderlyer"), processor, SingleUnderlyer.class, getSingleUnderlyer());
		processRosetta(path.newSubPath("basket"), processor, Basket.class, getBasket());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyerBuilder extends Underlyer, RosettaModelObjectBuilder {
		SingleUnderlyer.SingleUnderlyerBuilder getOrCreateSingleUnderlyer();
		@Override
		SingleUnderlyer.SingleUnderlyerBuilder getSingleUnderlyer();
		Basket.BasketBuilder getOrCreateBasket();
		@Override
		Basket.BasketBuilder getBasket();
		Underlyer.UnderlyerBuilder setSingleUnderlyer(SingleUnderlyer singleUnderlyer);
		Underlyer.UnderlyerBuilder setBasket(Basket basket);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("singleUnderlyer"), processor, SingleUnderlyer.SingleUnderlyerBuilder.class, getSingleUnderlyer());
			processRosetta(path.newSubPath("basket"), processor, Basket.BasketBuilder.class, getBasket());
		}
		

		Underlyer.UnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of Underlyer  ***********************/
	class UnderlyerImpl implements Underlyer {
		private final SingleUnderlyer singleUnderlyer;
		private final Basket basket;
		
		protected UnderlyerImpl(Underlyer.UnderlyerBuilder builder) {
			this.singleUnderlyer = ofNullable(builder.getSingleUnderlyer()).map(f->f.build()).orElse(null);
			this.basket = ofNullable(builder.getBasket()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("singleUnderlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("singleUnderlyer")
		public SingleUnderlyer getSingleUnderlyer() {
			return singleUnderlyer;
		}
		
		@Override
		@RosettaAttribute("basket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basket")
		public Basket getBasket() {
			return basket;
		}
		
		@Override
		public Underlyer build() {
			return this;
		}
		
		@Override
		public Underlyer.UnderlyerBuilder toBuilder() {
			Underlyer.UnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Underlyer.UnderlyerBuilder builder) {
			ofNullable(getSingleUnderlyer()).ifPresent(builder::setSingleUnderlyer);
			ofNullable(getBasket()).ifPresent(builder::setBasket);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Underlyer _that = getType().cast(o);
		
			if (!Objects.equals(singleUnderlyer, _that.getSingleUnderlyer())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singleUnderlyer != null ? singleUnderlyer.hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Underlyer {" +
				"singleUnderlyer=" + this.singleUnderlyer + ", " +
				"basket=" + this.basket +
			'}';
		}
	}

	/*********************** Builder Implementation of Underlyer  ***********************/
	class UnderlyerBuilderImpl implements Underlyer.UnderlyerBuilder {
	
		protected SingleUnderlyer.SingleUnderlyerBuilder singleUnderlyer;
		protected Basket.BasketBuilder basket;
		
		@Override
		@RosettaAttribute("singleUnderlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("singleUnderlyer")
		public SingleUnderlyer.SingleUnderlyerBuilder getSingleUnderlyer() {
			return singleUnderlyer;
		}
		
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder getOrCreateSingleUnderlyer() {
			SingleUnderlyer.SingleUnderlyerBuilder result;
			if (singleUnderlyer!=null) {
				result = singleUnderlyer;
			}
			else {
				result = singleUnderlyer = SingleUnderlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basket")
		public Basket.BasketBuilder getBasket() {
			return basket;
		}
		
		@Override
		public Basket.BasketBuilder getOrCreateBasket() {
			Basket.BasketBuilder result;
			if (basket!=null) {
				result = basket;
			}
			else {
				result = basket = Basket.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("singleUnderlyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("singleUnderlyer")
		@Override
		public Underlyer.UnderlyerBuilder setSingleUnderlyer(SingleUnderlyer _singleUnderlyer) {
			this.singleUnderlyer = _singleUnderlyer == null ? null : _singleUnderlyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("basket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basket")
		@Override
		public Underlyer.UnderlyerBuilder setBasket(Basket _basket) {
			this.basket = _basket == null ? null : _basket.toBuilder();
			return this;
		}
		
		@Override
		public Underlyer build() {
			return new Underlyer.UnderlyerImpl(this);
		}
		
		@Override
		public Underlyer.UnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Underlyer.UnderlyerBuilder prune() {
			if (singleUnderlyer!=null && !singleUnderlyer.prune().hasData()) singleUnderlyer = null;
			if (basket!=null && !basket.prune().hasData()) basket = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSingleUnderlyer()!=null && getSingleUnderlyer().hasData()) return true;
			if (getBasket()!=null && getBasket().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Underlyer.UnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Underlyer.UnderlyerBuilder o = (Underlyer.UnderlyerBuilder) other;
			
			merger.mergeRosetta(getSingleUnderlyer(), o.getSingleUnderlyer(), this::setSingleUnderlyer);
			merger.mergeRosetta(getBasket(), o.getBasket(), this::setBasket);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Underlyer _that = getType().cast(o);
		
			if (!Objects.equals(singleUnderlyer, _that.getSingleUnderlyer())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singleUnderlyer != null ? singleUnderlyer.hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerBuilder {" +
				"singleUnderlyer=" + this.singleUnderlyer + ", " +
				"basket=" + this.basket +
			'}';
		}
	}
}
