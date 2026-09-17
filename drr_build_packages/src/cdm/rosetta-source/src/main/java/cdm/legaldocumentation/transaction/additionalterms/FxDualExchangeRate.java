package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.FxDualExchangeRateMeta;
import cdm.observable.asset.FallbackReferencePrice;
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
 * section "5.1.(d).(ii)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxDualExchangeRate", builder=FxDualExchangeRate.FxDualExchangeRateBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FxDualExchangeRate", model="cdm", builder=FxDualExchangeRate.FxDualExchangeRateBuilderImpl.class, version="6.23.0")
public interface FxDualExchangeRate extends RosettaModelObject {

	FxDualExchangeRateMeta metaData = new FxDualExchangeRateMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getDualExchangeRateIsApplicable();
	/**
	 * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
	 */
	FallbackReferencePrice getFallbackReferencePrice();
	EscrowArrangement getEscrowArrangement();

	/*********************** Build Methods  ***********************/
	FxDualExchangeRate build();
	
	FxDualExchangeRate.FxDualExchangeRateBuilder toBuilder();
	
	static FxDualExchangeRate.FxDualExchangeRateBuilder builder() {
		return new FxDualExchangeRate.FxDualExchangeRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDualExchangeRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxDualExchangeRate> getType() {
		return FxDualExchangeRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dualExchangeRateIsApplicable"), Boolean.class, getDualExchangeRateIsApplicable(), this);
		processRosetta(path.newSubPath("fallbackReferencePrice"), processor, FallbackReferencePrice.class, getFallbackReferencePrice());
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDualExchangeRateBuilder extends FxDualExchangeRate, RosettaModelObjectBuilder {
		FallbackReferencePrice.FallbackReferencePriceBuilder getOrCreateFallbackReferencePrice();
		@Override
		FallbackReferencePrice.FallbackReferencePriceBuilder getFallbackReferencePrice();
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		FxDualExchangeRate.FxDualExchangeRateBuilder setDualExchangeRateIsApplicable(Boolean dualExchangeRateIsApplicable);
		FxDualExchangeRate.FxDualExchangeRateBuilder setFallbackReferencePrice(FallbackReferencePrice fallbackReferencePrice);
		FxDualExchangeRate.FxDualExchangeRateBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dualExchangeRateIsApplicable"), Boolean.class, getDualExchangeRateIsApplicable(), this);
			processRosetta(path.newSubPath("fallbackReferencePrice"), processor, FallbackReferencePrice.FallbackReferencePriceBuilder.class, getFallbackReferencePrice());
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
		}
		

		FxDualExchangeRate.FxDualExchangeRateBuilder prune();
	}

	/*********************** Immutable Implementation of FxDualExchangeRate  ***********************/
	class FxDualExchangeRateImpl implements FxDualExchangeRate {
		private final Boolean dualExchangeRateIsApplicable;
		private final FallbackReferencePrice fallbackReferencePrice;
		private final EscrowArrangement escrowArrangement;
		
		protected FxDualExchangeRateImpl(FxDualExchangeRate.FxDualExchangeRateBuilder builder) {
			this.dualExchangeRateIsApplicable = builder.getDualExchangeRateIsApplicable();
			this.fallbackReferencePrice = ofNullable(builder.getFallbackReferencePrice()).map(f->f.build()).orElse(null);
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dualExchangeRateIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dualExchangeRateIsApplicable")
		public Boolean getDualExchangeRateIsApplicable() {
			return dualExchangeRateIsApplicable;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackReferencePrice")
		public FallbackReferencePrice getFallbackReferencePrice() {
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
		public FxDualExchangeRate build() {
			return this;
		}
		
		@Override
		public FxDualExchangeRate.FxDualExchangeRateBuilder toBuilder() {
			FxDualExchangeRate.FxDualExchangeRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDualExchangeRate.FxDualExchangeRateBuilder builder) {
			ofNullable(getDualExchangeRateIsApplicable()).ifPresent(builder::setDualExchangeRateIsApplicable);
			ofNullable(getFallbackReferencePrice()).ifPresent(builder::setFallbackReferencePrice);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDualExchangeRate _that = getType().cast(o);
		
			if (!Objects.equals(dualExchangeRateIsApplicable, _that.getDualExchangeRateIsApplicable())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dualExchangeRateIsApplicable != null ? dualExchangeRateIsApplicable.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDualExchangeRate {" +
				"dualExchangeRateIsApplicable=" + this.dualExchangeRateIsApplicable + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDualExchangeRate  ***********************/
	class FxDualExchangeRateBuilderImpl implements FxDualExchangeRate.FxDualExchangeRateBuilder {
	
		protected Boolean dualExchangeRateIsApplicable;
		protected FallbackReferencePrice.FallbackReferencePriceBuilder fallbackReferencePrice;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		
		@Override
		@RosettaAttribute("dualExchangeRateIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dualExchangeRateIsApplicable")
		public Boolean getDualExchangeRateIsApplicable() {
			return dualExchangeRateIsApplicable;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackReferencePrice")
		public FallbackReferencePrice.FallbackReferencePriceBuilder getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public FallbackReferencePrice.FallbackReferencePriceBuilder getOrCreateFallbackReferencePrice() {
			FallbackReferencePrice.FallbackReferencePriceBuilder result;
			if (fallbackReferencePrice!=null) {
				result = fallbackReferencePrice;
			}
			else {
				result = fallbackReferencePrice = FallbackReferencePrice.builder();
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
		
		@RosettaAttribute("dualExchangeRateIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dualExchangeRateIsApplicable")
		@Override
		public FxDualExchangeRate.FxDualExchangeRateBuilder setDualExchangeRateIsApplicable(Boolean _dualExchangeRateIsApplicable) {
			this.dualExchangeRateIsApplicable = _dualExchangeRateIsApplicable == null ? null : _dualExchangeRateIsApplicable;
			return this;
		}
		
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackReferencePrice")
		@Override
		public FxDualExchangeRate.FxDualExchangeRateBuilder setFallbackReferencePrice(FallbackReferencePrice _fallbackReferencePrice) {
			this.fallbackReferencePrice = _fallbackReferencePrice == null ? null : _fallbackReferencePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public FxDualExchangeRate.FxDualExchangeRateBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@Override
		public FxDualExchangeRate build() {
			return new FxDualExchangeRate.FxDualExchangeRateImpl(this);
		}
		
		@Override
		public FxDualExchangeRate.FxDualExchangeRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDualExchangeRate.FxDualExchangeRateBuilder prune() {
			if (fallbackReferencePrice!=null && !fallbackReferencePrice.prune().hasData()) fallbackReferencePrice = null;
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDualExchangeRateIsApplicable()!=null) return true;
			if (getFallbackReferencePrice()!=null && getFallbackReferencePrice().hasData()) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDualExchangeRate.FxDualExchangeRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDualExchangeRate.FxDualExchangeRateBuilder o = (FxDualExchangeRate.FxDualExchangeRateBuilder) other;
			
			merger.mergeRosetta(getFallbackReferencePrice(), o.getFallbackReferencePrice(), this::setFallbackReferencePrice);
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			
			merger.mergeBasic(getDualExchangeRateIsApplicable(), o.getDualExchangeRateIsApplicable(), this::setDualExchangeRateIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDualExchangeRate _that = getType().cast(o);
		
			if (!Objects.equals(dualExchangeRateIsApplicable, _that.getDualExchangeRateIsApplicable())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dualExchangeRateIsApplicable != null ? dualExchangeRateIsApplicable.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDualExchangeRateBuilder {" +
				"dualExchangeRateIsApplicable=" + this.dualExchangeRateIsApplicable + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice + ", " +
				"escrowArrangement=" + this.escrowArrangement +
			'}';
		}
	}
}
