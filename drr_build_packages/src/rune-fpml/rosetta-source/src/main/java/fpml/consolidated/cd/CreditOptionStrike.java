package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.CreditOptionStrikeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A complex type to specify the strike of a credit swaption or a credit default swap option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A complex type to specify the strike of a credit swaption or a credit default swap option.
 *
 */
@RosettaDataType(value="CreditOptionStrike", builder=CreditOptionStrike.CreditOptionStrikeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditOptionStrike", model="fpml", builder=CreditOptionStrike.CreditOptionStrikeBuilderImpl.class, version="2.1.1")
public interface CreditOptionStrike extends RosettaModelObject {

	CreditOptionStrikeMeta metaData = new CreditOptionStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The strike of a credit default swap option or credit swaption when expressed as a spread per annum.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The strike of a credit default swap option or credit swaption when expressed as a spread per annum.
	 *
	 */
	BigDecimal getSpread();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The strike of a credit default swap option or credit swaption when expressed as in reference to the price of the underlying obligation(s) or index.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The strike of a credit default swap option or credit swaption when expressed as in reference to the price of the underlying obligation(s) or index.
	 *
	 */
	BigDecimal getPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The strike of a credit default swap option or credit swaption when expressed in reference to the spread of the underlying swap (typical practice in the case of single name swaps).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The strike of a credit default swap option or credit swaption when expressed in reference to the spread of the underlying swap (typical practice in the case of single name swaps).
	 *
	 */
	FixedRateReference getStrikeReference();

	/*********************** Build Methods  ***********************/
	CreditOptionStrike build();
	
	CreditOptionStrike.CreditOptionStrikeBuilder toBuilder();
	
	static CreditOptionStrike.CreditOptionStrikeBuilder builder() {
		return new CreditOptionStrike.CreditOptionStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditOptionStrike> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditOptionStrike> getType() {
		return CreditOptionStrike.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processRosetta(path.newSubPath("strikeReference"), processor, FixedRateReference.class, getStrikeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditOptionStrikeBuilder extends CreditOptionStrike, RosettaModelObjectBuilder {
		FixedRateReference.FixedRateReferenceBuilder getOrCreateStrikeReference();
		@Override
		FixedRateReference.FixedRateReferenceBuilder getStrikeReference();
		CreditOptionStrike.CreditOptionStrikeBuilder setSpread(BigDecimal spread);
		CreditOptionStrike.CreditOptionStrikeBuilder setPrice(BigDecimal price);
		CreditOptionStrike.CreditOptionStrikeBuilder setStrikeReference(FixedRateReference strikeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processRosetta(path.newSubPath("strikeReference"), processor, FixedRateReference.FixedRateReferenceBuilder.class, getStrikeReference());
		}
		

		CreditOptionStrike.CreditOptionStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of CreditOptionStrike  ***********************/
	class CreditOptionStrikeImpl implements CreditOptionStrike {
		private final BigDecimal spread;
		private final BigDecimal price;
		private final FixedRateReference strikeReference;
		
		protected CreditOptionStrikeImpl(CreditOptionStrike.CreditOptionStrikeBuilder builder) {
			this.spread = builder.getSpread();
			this.price = builder.getPrice();
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FixedRateReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public CreditOptionStrike build() {
			return this;
		}
		
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder toBuilder() {
			CreditOptionStrike.CreditOptionStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditOptionStrike.CreditOptionStrikeBuilder builder) {
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditOptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditOptionStrike {" +
				"spread=" + this.spread + ", " +
				"price=" + this.price + ", " +
				"strikeReference=" + this.strikeReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditOptionStrike  ***********************/
	class CreditOptionStrikeBuilderImpl implements CreditOptionStrike.CreditOptionStrikeBuilder {
	
		protected BigDecimal spread;
		protected BigDecimal price;
		protected FixedRateReference.FixedRateReferenceBuilder strikeReference;
		
		@Override
		@RosettaAttribute("spread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FixedRateReference.FixedRateReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FixedRateReference.FixedRateReferenceBuilder getOrCreateStrikeReference() {
			FixedRateReference.FixedRateReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FixedRateReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("spread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spread")
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder setSpread(BigDecimal _spread) {
			this.spread = _spread == null ? null : _spread;
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder setPrice(BigDecimal _price) {
			this.price = _price == null ? null : _price;
			return this;
		}
		
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeReference")
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder setStrikeReference(FixedRateReference _strikeReference) {
			this.strikeReference = _strikeReference == null ? null : _strikeReference.toBuilder();
			return this;
		}
		
		@Override
		public CreditOptionStrike build() {
			return new CreditOptionStrike.CreditOptionStrikeImpl(this);
		}
		
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder prune() {
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpread()!=null) return true;
			if (getPrice()!=null) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditOptionStrike.CreditOptionStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditOptionStrike.CreditOptionStrikeBuilder o = (CreditOptionStrike.CreditOptionStrikeBuilder) other;
			
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			
			merger.mergeBasic(getSpread(), o.getSpread(), this::setSpread);
			merger.mergeBasic(getPrice(), o.getPrice(), this::setPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditOptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditOptionStrikeBuilder {" +
				"spread=" + this.spread + ", " +
				"price=" + this.price + ", " +
				"strikeReference=" + this.strikeReference +
			'}';
		}
	}
}
