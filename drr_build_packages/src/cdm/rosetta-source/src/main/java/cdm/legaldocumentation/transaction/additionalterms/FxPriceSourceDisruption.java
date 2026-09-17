package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.FxPriceSourceDisruptionMeta;
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
 * section "5.1.(d).(xi)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxPriceSourceDisruption", builder=FxPriceSourceDisruption.FxPriceSourceDisruptionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FxPriceSourceDisruption", model="cdm", builder=FxPriceSourceDisruption.FxPriceSourceDisruptionBuilderImpl.class, version="6.23.0")
public interface FxPriceSourceDisruption extends RosettaModelObject {

	FxPriceSourceDisruptionMeta metaData = new FxPriceSourceDisruptionMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getPriceSourceDisruptionIsApplicable();
	/**
	 * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
	 */
	SettlementRateOption getFallbackReferencePrice();
	EscrowArrangement getEscrowArrangement();

	/*********************** Build Methods  ***********************/
	FxPriceSourceDisruption build();
	
	FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder toBuilder();
	
	static FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder builder() {
		return new FxPriceSourceDisruption.FxPriceSourceDisruptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPriceSourceDisruption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxPriceSourceDisruption> getType() {
		return FxPriceSourceDisruption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("priceSourceDisruptionIsApplicable"), Boolean.class, getPriceSourceDisruptionIsApplicable(), this);
		processRosetta(path.newSubPath("fallbackReferencePrice"), processor, SettlementRateOption.class, getFallbackReferencePrice());
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPriceSourceDisruptionBuilder extends FxPriceSourceDisruption, RosettaModelObjectBuilder {
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateFallbackReferencePrice();
		@Override
		SettlementRateOption.SettlementRateOptionBuilder getFallbackReferencePrice();
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder setPriceSourceDisruptionIsApplicable(Boolean priceSourceDisruptionIsApplicable);
		FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder setFallbackReferencePrice(SettlementRateOption fallbackReferencePrice);
		FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("priceSourceDisruptionIsApplicable"), Boolean.class, getPriceSourceDisruptionIsApplicable(), this);
			processRosetta(path.newSubPath("fallbackReferencePrice"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getFallbackReferencePrice());
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
		}
		

		FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder prune();
	}

	/*********************** Immutable Implementation of FxPriceSourceDisruption  ***********************/
	class FxPriceSourceDisruptionImpl implements FxPriceSourceDisruption {
		private final Boolean priceSourceDisruptionIsApplicable;
		private final SettlementRateOption fallbackReferencePrice;
		private final EscrowArrangement escrowArrangement;
		
		protected FxPriceSourceDisruptionImpl(FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder builder) {
			this.priceSourceDisruptionIsApplicable = builder.getPriceSourceDisruptionIsApplicable();
			this.fallbackReferencePrice = ofNullable(builder.getFallbackReferencePrice()).map(f->f.build()).orElse(null);
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("priceSourceDisruptionIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("priceSourceDisruptionIsApplicable")
		public Boolean getPriceSourceDisruptionIsApplicable() {
			return priceSourceDisruptionIsApplicable;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackReferencePrice")
		public SettlementRateOption getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		public FxPriceSourceDisruption build() {
			return this;
		}
		
		@Override
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder toBuilder() {
			FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder builder) {
			ofNullable(getPriceSourceDisruptionIsApplicable()).ifPresent(builder::setPriceSourceDisruptionIsApplicable);
			ofNullable(getFallbackReferencePrice()).ifPresent(builder::setFallbackReferencePrice);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxPriceSourceDisruption _that = getType().cast(o);
		
			if (!Objects.equals(priceSourceDisruptionIsApplicable, _that.getPriceSourceDisruptionIsApplicable())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceSourceDisruptionIsApplicable != null ? priceSourceDisruptionIsApplicable.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPriceSourceDisruption {" +
				"priceSourceDisruptionIsApplicable=" + this.priceSourceDisruptionIsApplicable + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}

	/*********************** Builder Implementation of FxPriceSourceDisruption  ***********************/
	class FxPriceSourceDisruptionBuilderImpl implements FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder {
	
		protected Boolean priceSourceDisruptionIsApplicable;
		protected SettlementRateOption.SettlementRateOptionBuilder fallbackReferencePrice;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		
		@Override
		@RosettaAttribute("priceSourceDisruptionIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("priceSourceDisruptionIsApplicable")
		public Boolean getPriceSourceDisruptionIsApplicable() {
			return priceSourceDisruptionIsApplicable;
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
		
		@RosettaAttribute("priceSourceDisruptionIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("priceSourceDisruptionIsApplicable")
		@Override
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder setPriceSourceDisruptionIsApplicable(Boolean _priceSourceDisruptionIsApplicable) {
			this.priceSourceDisruptionIsApplicable = _priceSourceDisruptionIsApplicable == null ? null : _priceSourceDisruptionIsApplicable;
			return this;
		}
		
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackReferencePrice")
		@Override
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder setFallbackReferencePrice(SettlementRateOption _fallbackReferencePrice) {
			this.fallbackReferencePrice = _fallbackReferencePrice == null ? null : _fallbackReferencePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@Override
		public FxPriceSourceDisruption build() {
			return new FxPriceSourceDisruption.FxPriceSourceDisruptionImpl(this);
		}
		
		@Override
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder prune() {
			if (fallbackReferencePrice!=null && !fallbackReferencePrice.prune().hasData()) fallbackReferencePrice = null;
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPriceSourceDisruptionIsApplicable()!=null) return true;
			if (getFallbackReferencePrice()!=null && getFallbackReferencePrice().hasData()) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder o = (FxPriceSourceDisruption.FxPriceSourceDisruptionBuilder) other;
			
			merger.mergeRosetta(getFallbackReferencePrice(), o.getFallbackReferencePrice(), this::setFallbackReferencePrice);
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			
			merger.mergeBasic(getPriceSourceDisruptionIsApplicable(), o.getPriceSourceDisruptionIsApplicable(), this::setPriceSourceDisruptionIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxPriceSourceDisruption _that = getType().cast(o);
		
			if (!Objects.equals(priceSourceDisruptionIsApplicable, _that.getPriceSourceDisruptionIsApplicable())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceSourceDisruptionIsApplicable != null ? priceSourceDisruptionIsApplicable.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPriceSourceDisruptionBuilder {" +
				"priceSourceDisruptionIsApplicable=" + this.priceSourceDisruptionIsApplicable + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}
}
