package cdm.legaldocumentation.transaction.additionalterms;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.math.Quantity;
import cdm.legaldocumentation.transaction.additionalterms.meta.IlliquidityMeta;
import cdm.observable.asset.SettlementRateOption;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
 * section "5.1.(d).(vi)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="Illiquidity", builder=Illiquidity.IlliquidityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Illiquidity", model="cdm", builder=Illiquidity.IlliquidityBuilderImpl.class, version="6.23.0")
public interface Illiquidity extends RosettaModelObject {

	IlliquidityMeta metaData = new IlliquidityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Definitions FXandCurrencyOptionsDefintions_1998 1998 FX and Currency Option Definitions  
	 * section "5.1.(d).(vi)"
	 *
	 * Provision 
	 *
	 */
	Boolean getIlliquidityIsApplicable();
	EscrowArrangement getEscrowArrangement();
	Quantity getMinimumAmount();
	/**
	 * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
	 */
	SettlementRateOption getFallbackReferencePrice();
	AdjustedRelativeDateOffset getIlliquidityValuationDate();

	/*********************** Build Methods  ***********************/
	Illiquidity build();
	
	Illiquidity.IlliquidityBuilder toBuilder();
	
	static Illiquidity.IlliquidityBuilder builder() {
		return new Illiquidity.IlliquidityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Illiquidity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Illiquidity> getType() {
		return Illiquidity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("illiquidityIsApplicable"), Boolean.class, getIlliquidityIsApplicable(), this);
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
		processRosetta(path.newSubPath("minimumAmount"), processor, Quantity.class, getMinimumAmount());
		processRosetta(path.newSubPath("fallbackReferencePrice"), processor, SettlementRateOption.class, getFallbackReferencePrice());
		processRosetta(path.newSubPath("illiquidityValuationDate"), processor, AdjustedRelativeDateOffset.class, getIlliquidityValuationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IlliquidityBuilder extends Illiquidity, RosettaModelObjectBuilder {
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		Quantity.QuantityBuilder getOrCreateMinimumAmount();
		@Override
		Quantity.QuantityBuilder getMinimumAmount();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateFallbackReferencePrice();
		@Override
		SettlementRateOption.SettlementRateOptionBuilder getFallbackReferencePrice();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateIlliquidityValuationDate();
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getIlliquidityValuationDate();
		Illiquidity.IlliquidityBuilder setIlliquidityIsApplicable(Boolean illiquidityIsApplicable);
		Illiquidity.IlliquidityBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);
		Illiquidity.IlliquidityBuilder setMinimumAmount(Quantity minimumAmount);
		Illiquidity.IlliquidityBuilder setFallbackReferencePrice(SettlementRateOption fallbackReferencePrice);
		Illiquidity.IlliquidityBuilder setIlliquidityValuationDate(AdjustedRelativeDateOffset illiquidityValuationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("illiquidityIsApplicable"), Boolean.class, getIlliquidityIsApplicable(), this);
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
			processRosetta(path.newSubPath("minimumAmount"), processor, Quantity.QuantityBuilder.class, getMinimumAmount());
			processRosetta(path.newSubPath("fallbackReferencePrice"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getFallbackReferencePrice());
			processRosetta(path.newSubPath("illiquidityValuationDate"), processor, AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder.class, getIlliquidityValuationDate());
		}
		

		Illiquidity.IlliquidityBuilder prune();
	}

	/*********************** Immutable Implementation of Illiquidity  ***********************/
	class IlliquidityImpl implements Illiquidity {
		private final Boolean illiquidityIsApplicable;
		private final EscrowArrangement escrowArrangement;
		private final Quantity minimumAmount;
		private final SettlementRateOption fallbackReferencePrice;
		private final AdjustedRelativeDateOffset illiquidityValuationDate;
		
		protected IlliquidityImpl(Illiquidity.IlliquidityBuilder builder) {
			this.illiquidityIsApplicable = builder.getIlliquidityIsApplicable();
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
			this.minimumAmount = ofNullable(builder.getMinimumAmount()).map(f->f.build()).orElse(null);
			this.fallbackReferencePrice = ofNullable(builder.getFallbackReferencePrice()).map(f->f.build()).orElse(null);
			this.illiquidityValuationDate = ofNullable(builder.getIlliquidityValuationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("illiquidityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("illiquidityIsApplicable")
		public Boolean getIlliquidityIsApplicable() {
			return illiquidityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		@RosettaAttribute("minimumAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumAmount")
		public Quantity getMinimumAmount() {
			return minimumAmount;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackReferencePrice")
		public SettlementRateOption getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		@RosettaAttribute("illiquidityValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("illiquidityValuationDate")
		public AdjustedRelativeDateOffset getIlliquidityValuationDate() {
			return illiquidityValuationDate;
		}
		
		@Override
		public Illiquidity build() {
			return this;
		}
		
		@Override
		public Illiquidity.IlliquidityBuilder toBuilder() {
			Illiquidity.IlliquidityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Illiquidity.IlliquidityBuilder builder) {
			ofNullable(getIlliquidityIsApplicable()).ifPresent(builder::setIlliquidityIsApplicable);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
			ofNullable(getMinimumAmount()).ifPresent(builder::setMinimumAmount);
			ofNullable(getFallbackReferencePrice()).ifPresent(builder::setFallbackReferencePrice);
			ofNullable(getIlliquidityValuationDate()).ifPresent(builder::setIlliquidityValuationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Illiquidity _that = getType().cast(o);
		
			if (!Objects.equals(illiquidityIsApplicable, _that.getIlliquidityIsApplicable())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(minimumAmount, _that.getMinimumAmount())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(illiquidityValuationDate, _that.getIlliquidityValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (illiquidityIsApplicable != null ? illiquidityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (minimumAmount != null ? minimumAmount.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (illiquidityValuationDate != null ? illiquidityValuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Illiquidity {" +
				"illiquidityIsApplicable=" + this.illiquidityIsApplicable + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"minimumAmount=" + this.minimumAmount + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"illiquidityValuationDate=" + this.illiquidityValuationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of Illiquidity  ***********************/
	class IlliquidityBuilderImpl implements Illiquidity.IlliquidityBuilder {
	
		protected Boolean illiquidityIsApplicable;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		protected Quantity.QuantityBuilder minimumAmount;
		protected SettlementRateOption.SettlementRateOptionBuilder fallbackReferencePrice;
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder illiquidityValuationDate;
		
		@Override
		@RosettaAttribute("illiquidityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("illiquidityIsApplicable")
		public Boolean getIlliquidityIsApplicable() {
			return illiquidityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		public EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement() {
			EscrowArrangement.EscrowArrangementBuilder result;
			if (escrowArrangement!=null) {
				result = escrowArrangement;
			}
			else {
				result = escrowArrangement = EscrowArrangement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumAmount")
		public Quantity.QuantityBuilder getMinimumAmount() {
			return minimumAmount;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateMinimumAmount() {
			Quantity.QuantityBuilder result;
			if (minimumAmount!=null) {
				result = minimumAmount;
			}
			else {
				result = minimumAmount = Quantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackReferencePrice")
		public SettlementRateOption.SettlementRateOptionBuilder getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateFallbackReferencePrice() {
			SettlementRateOption.SettlementRateOptionBuilder result;
			if (fallbackReferencePrice!=null) {
				result = fallbackReferencePrice;
			}
			else {
				result = fallbackReferencePrice = SettlementRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("illiquidityValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("illiquidityValuationDate")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getIlliquidityValuationDate() {
			return illiquidityValuationDate;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateIlliquidityValuationDate() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder result;
			if (illiquidityValuationDate!=null) {
				result = illiquidityValuationDate;
			}
			else {
				result = illiquidityValuationDate = AdjustedRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("illiquidityIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("illiquidityIsApplicable")
		@Override
		public Illiquidity.IlliquidityBuilder setIlliquidityIsApplicable(Boolean _illiquidityIsApplicable) {
			this.illiquidityIsApplicable = _illiquidityIsApplicable == null ? null : _illiquidityIsApplicable;
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public Illiquidity.IlliquidityBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumAmount")
		@Override
		public Illiquidity.IlliquidityBuilder setMinimumAmount(Quantity _minimumAmount) {
			this.minimumAmount = _minimumAmount == null ? null : _minimumAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackReferencePrice")
		@Override
		public Illiquidity.IlliquidityBuilder setFallbackReferencePrice(SettlementRateOption _fallbackReferencePrice) {
			this.fallbackReferencePrice = _fallbackReferencePrice == null ? null : _fallbackReferencePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("illiquidityValuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("illiquidityValuationDate")
		@Override
		public Illiquidity.IlliquidityBuilder setIlliquidityValuationDate(AdjustedRelativeDateOffset _illiquidityValuationDate) {
			this.illiquidityValuationDate = _illiquidityValuationDate == null ? null : _illiquidityValuationDate.toBuilder();
			return this;
		}
		
		@Override
		public Illiquidity build() {
			return new Illiquidity.IlliquidityImpl(this);
		}
		
		@Override
		public Illiquidity.IlliquidityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Illiquidity.IlliquidityBuilder prune() {
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			if (minimumAmount!=null && !minimumAmount.prune().hasData()) minimumAmount = null;
			if (fallbackReferencePrice!=null && !fallbackReferencePrice.prune().hasData()) fallbackReferencePrice = null;
			if (illiquidityValuationDate!=null && !illiquidityValuationDate.prune().hasData()) illiquidityValuationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIlliquidityIsApplicable()!=null) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			if (getMinimumAmount()!=null && getMinimumAmount().hasData()) return true;
			if (getFallbackReferencePrice()!=null && getFallbackReferencePrice().hasData()) return true;
			if (getIlliquidityValuationDate()!=null && getIlliquidityValuationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Illiquidity.IlliquidityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Illiquidity.IlliquidityBuilder o = (Illiquidity.IlliquidityBuilder) other;
			
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			merger.mergeRosetta(getMinimumAmount(), o.getMinimumAmount(), this::setMinimumAmount);
			merger.mergeRosetta(getFallbackReferencePrice(), o.getFallbackReferencePrice(), this::setFallbackReferencePrice);
			merger.mergeRosetta(getIlliquidityValuationDate(), o.getIlliquidityValuationDate(), this::setIlliquidityValuationDate);
			
			merger.mergeBasic(getIlliquidityIsApplicable(), o.getIlliquidityIsApplicable(), this::setIlliquidityIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Illiquidity _that = getType().cast(o);
		
			if (!Objects.equals(illiquidityIsApplicable, _that.getIlliquidityIsApplicable())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(minimumAmount, _that.getMinimumAmount())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(illiquidityValuationDate, _that.getIlliquidityValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (illiquidityIsApplicable != null ? illiquidityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (minimumAmount != null ? minimumAmount.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (illiquidityValuationDate != null ? illiquidityValuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IlliquidityBuilder {" +
				"illiquidityIsApplicable=" + this.illiquidityIsApplicable + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"minimumAmount=" + this.minimumAmount + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"illiquidityValuationDate=" + this.illiquidityValuationDate +
			'}';
		}
	}
}
