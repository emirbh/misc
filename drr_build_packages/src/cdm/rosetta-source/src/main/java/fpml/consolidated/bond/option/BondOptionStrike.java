package fpml.consolidated.bond.option;

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
import fpml.consolidated.bond.option.meta.BondOptionStrikeMeta;
import fpml.consolidated.option.shared.OptionStrike;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A complex type to specify the strike of a bond or convertible bond option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A complex type to specify the strike of a bond or convertible bond option.
 *
 */
@RosettaDataType(value="BondOptionStrike", builder=BondOptionStrike.BondOptionStrikeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BondOptionStrike", model="fpml", builder=BondOptionStrike.BondOptionStrikeBuilderImpl.class, version="2.1.1")
public interface BondOptionStrike extends RosettaModelObject {

	BondOptionStrikeMeta metaData = new BondOptionStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The strike of an option when expressed by reference to a swap curve. (Typically the case for a convertible bond option.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The strike of an option when expressed by reference to a swap curve. (Typically the case for a convertible bond option.)
	 *
	 */
	ReferenceSwapCurve getReferenceSwapCurve();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	OptionStrike getPrice();

	/*********************** Build Methods  ***********************/
	BondOptionStrike build();
	
	BondOptionStrike.BondOptionStrikeBuilder toBuilder();
	
	static BondOptionStrike.BondOptionStrikeBuilder builder() {
		return new BondOptionStrike.BondOptionStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BondOptionStrike> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BondOptionStrike> getType() {
		return BondOptionStrike.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("referenceSwapCurve"), processor, ReferenceSwapCurve.class, getReferenceSwapCurve());
		processRosetta(path.newSubPath("price"), processor, OptionStrike.class, getPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondOptionStrikeBuilder extends BondOptionStrike, RosettaModelObjectBuilder {
		ReferenceSwapCurve.ReferenceSwapCurveBuilder getOrCreateReferenceSwapCurve();
		@Override
		ReferenceSwapCurve.ReferenceSwapCurveBuilder getReferenceSwapCurve();
		OptionStrike.OptionStrikeBuilder getOrCreatePrice();
		@Override
		OptionStrike.OptionStrikeBuilder getPrice();
		BondOptionStrike.BondOptionStrikeBuilder setReferenceSwapCurve(ReferenceSwapCurve referenceSwapCurve);
		BondOptionStrike.BondOptionStrikeBuilder setPrice(OptionStrike price);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("referenceSwapCurve"), processor, ReferenceSwapCurve.ReferenceSwapCurveBuilder.class, getReferenceSwapCurve());
			processRosetta(path.newSubPath("price"), processor, OptionStrike.OptionStrikeBuilder.class, getPrice());
		}
		

		BondOptionStrike.BondOptionStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of BondOptionStrike  ***********************/
	class BondOptionStrikeImpl implements BondOptionStrike {
		private final ReferenceSwapCurve referenceSwapCurve;
		private final OptionStrike price;
		
		protected BondOptionStrikeImpl(BondOptionStrike.BondOptionStrikeBuilder builder) {
			this.referenceSwapCurve = ofNullable(builder.getReferenceSwapCurve()).map(f->f.build()).orElse(null);
			this.price = ofNullable(builder.getPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("referenceSwapCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceSwapCurve")
		public ReferenceSwapCurve getReferenceSwapCurve() {
			return referenceSwapCurve;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public OptionStrike getPrice() {
			return price;
		}
		
		@Override
		public BondOptionStrike build() {
			return this;
		}
		
		@Override
		public BondOptionStrike.BondOptionStrikeBuilder toBuilder() {
			BondOptionStrike.BondOptionStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondOptionStrike.BondOptionStrikeBuilder builder) {
			ofNullable(getReferenceSwapCurve()).ifPresent(builder::setReferenceSwapCurve);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondOptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(referenceSwapCurve, _that.getReferenceSwapCurve())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceSwapCurve != null ? referenceSwapCurve.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondOptionStrike {" +
				"referenceSwapCurve=" + this.referenceSwapCurve + ", " +
				"price=" + this.price +
			'}';
		}
	}

	/*********************** Builder Implementation of BondOptionStrike  ***********************/
	class BondOptionStrikeBuilderImpl implements BondOptionStrike.BondOptionStrikeBuilder {
	
		protected ReferenceSwapCurve.ReferenceSwapCurveBuilder referenceSwapCurve;
		protected OptionStrike.OptionStrikeBuilder price;
		
		@Override
		@RosettaAttribute("referenceSwapCurve")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceSwapCurve")
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder getReferenceSwapCurve() {
			return referenceSwapCurve;
		}
		
		@Override
		public ReferenceSwapCurve.ReferenceSwapCurveBuilder getOrCreateReferenceSwapCurve() {
			ReferenceSwapCurve.ReferenceSwapCurveBuilder result;
			if (referenceSwapCurve!=null) {
				result = referenceSwapCurve;
			}
			else {
				result = referenceSwapCurve = ReferenceSwapCurve.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public OptionStrike.OptionStrikeBuilder getPrice() {
			return price;
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder getOrCreatePrice() {
			OptionStrike.OptionStrikeBuilder result;
			if (price!=null) {
				result = price;
			}
			else {
				result = price = OptionStrike.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("referenceSwapCurve")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceSwapCurve")
		@Override
		public BondOptionStrike.BondOptionStrikeBuilder setReferenceSwapCurve(ReferenceSwapCurve _referenceSwapCurve) {
			this.referenceSwapCurve = _referenceSwapCurve == null ? null : _referenceSwapCurve.toBuilder();
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public BondOptionStrike.BondOptionStrikeBuilder setPrice(OptionStrike _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@Override
		public BondOptionStrike build() {
			return new BondOptionStrike.BondOptionStrikeImpl(this);
		}
		
		@Override
		public BondOptionStrike.BondOptionStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondOptionStrike.BondOptionStrikeBuilder prune() {
			if (referenceSwapCurve!=null && !referenceSwapCurve.prune().hasData()) referenceSwapCurve = null;
			if (price!=null && !price.prune().hasData()) price = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceSwapCurve()!=null && getReferenceSwapCurve().hasData()) return true;
			if (getPrice()!=null && getPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondOptionStrike.BondOptionStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondOptionStrike.BondOptionStrikeBuilder o = (BondOptionStrike.BondOptionStrikeBuilder) other;
			
			merger.mergeRosetta(getReferenceSwapCurve(), o.getReferenceSwapCurve(), this::setReferenceSwapCurve);
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondOptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(referenceSwapCurve, _that.getReferenceSwapCurve())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceSwapCurve != null ? referenceSwapCurve.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondOptionStrikeBuilder {" +
				"referenceSwapCurve=" + this.referenceSwapCurve + ", " +
				"price=" + this.price +
			'}';
		}
	}
}
