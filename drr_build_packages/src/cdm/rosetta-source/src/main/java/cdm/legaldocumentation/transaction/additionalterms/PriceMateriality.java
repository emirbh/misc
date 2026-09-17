package cdm.legaldocumentation.transaction.additionalterms;

import cdm.legaldocumentation.transaction.additionalterms.meta.PriceMaterialityMeta;
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
 * section "5.1.(d).(x)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="PriceMateriality", builder=PriceMateriality.PriceMaterialityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PriceMateriality", model="cdm", builder=PriceMateriality.PriceMaterialityBuilderImpl.class, version="6.23.0")
public interface PriceMateriality extends RosettaModelObject {

	PriceMaterialityMeta metaData = new PriceMaterialityMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getPriceMaterialityIsApplicable();
	EscrowArrangement getEscrowArrangement();
	/**
	 * The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
	 */
	SettlementRateOption getFallbackReferencePrice();

	/*********************** Build Methods  ***********************/
	PriceMateriality build();
	
	PriceMateriality.PriceMaterialityBuilder toBuilder();
	
	static PriceMateriality.PriceMaterialityBuilder builder() {
		return new PriceMateriality.PriceMaterialityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceMateriality> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PriceMateriality> getType() {
		return PriceMateriality.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("priceMaterialityIsApplicable"), Boolean.class, getPriceMaterialityIsApplicable(), this);
		processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.class, getEscrowArrangement());
		processRosetta(path.newSubPath("fallbackReferencePrice"), processor, SettlementRateOption.class, getFallbackReferencePrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceMaterialityBuilder extends PriceMateriality, RosettaModelObjectBuilder {
		EscrowArrangement.EscrowArrangementBuilder getOrCreateEscrowArrangement();
		@Override
		EscrowArrangement.EscrowArrangementBuilder getEscrowArrangement();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateFallbackReferencePrice();
		@Override
		SettlementRateOption.SettlementRateOptionBuilder getFallbackReferencePrice();
		PriceMateriality.PriceMaterialityBuilder setPriceMaterialityIsApplicable(Boolean priceMaterialityIsApplicable);
		PriceMateriality.PriceMaterialityBuilder setEscrowArrangement(EscrowArrangement escrowArrangement);
		PriceMateriality.PriceMaterialityBuilder setFallbackReferencePrice(SettlementRateOption fallbackReferencePrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("priceMaterialityIsApplicable"), Boolean.class, getPriceMaterialityIsApplicable(), this);
			processRosetta(path.newSubPath("escrowArrangement"), processor, EscrowArrangement.EscrowArrangementBuilder.class, getEscrowArrangement());
			processRosetta(path.newSubPath("fallbackReferencePrice"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getFallbackReferencePrice());
		}
		

		PriceMateriality.PriceMaterialityBuilder prune();
	}

	/*********************** Immutable Implementation of PriceMateriality  ***********************/
	class PriceMaterialityImpl implements PriceMateriality {
		private final Boolean priceMaterialityIsApplicable;
		private final EscrowArrangement escrowArrangement;
		private final SettlementRateOption fallbackReferencePrice;
		
		protected PriceMaterialityImpl(PriceMateriality.PriceMaterialityBuilder builder) {
			this.priceMaterialityIsApplicable = builder.getPriceMaterialityIsApplicable();
			this.escrowArrangement = ofNullable(builder.getEscrowArrangement()).map(f->f.build()).orElse(null);
			this.fallbackReferencePrice = ofNullable(builder.getFallbackReferencePrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("priceMaterialityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("priceMaterialityIsApplicable")
		public Boolean getPriceMaterialityIsApplicable() {
			return priceMaterialityIsApplicable;
		}
		
		@Override
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("escrowArrangement")
		public EscrowArrangement getEscrowArrangement() {
			return escrowArrangement;
		}
		
		@Override
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackReferencePrice")
		public SettlementRateOption getFallbackReferencePrice() {
			return fallbackReferencePrice;
		}
		
		@Override
		public PriceMateriality build() {
			return this;
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder toBuilder() {
			PriceMateriality.PriceMaterialityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceMateriality.PriceMaterialityBuilder builder) {
			ofNullable(getPriceMaterialityIsApplicable()).ifPresent(builder::setPriceMaterialityIsApplicable);
			ofNullable(getEscrowArrangement()).ifPresent(builder::setEscrowArrangement);
			ofNullable(getFallbackReferencePrice()).ifPresent(builder::setFallbackReferencePrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceMateriality _that = getType().cast(o);
		
			if (!Objects.equals(priceMaterialityIsApplicable, _that.getPriceMaterialityIsApplicable())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceMaterialityIsApplicable != null ? priceMaterialityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceMateriality {" +
				"priceMaterialityIsApplicable=" + this.priceMaterialityIsApplicable + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceMateriality  ***********************/
	class PriceMaterialityBuilderImpl implements PriceMateriality.PriceMaterialityBuilder {
	
		protected Boolean priceMaterialityIsApplicable;
		protected EscrowArrangement.EscrowArrangementBuilder escrowArrangement;
		protected SettlementRateOption.SettlementRateOptionBuilder fallbackReferencePrice;
		
		@Override
		@RosettaAttribute("priceMaterialityIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("priceMaterialityIsApplicable")
		public Boolean getPriceMaterialityIsApplicable() {
			return priceMaterialityIsApplicable;
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
		
		@RosettaAttribute("priceMaterialityIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("priceMaterialityIsApplicable")
		@Override
		public PriceMateriality.PriceMaterialityBuilder setPriceMaterialityIsApplicable(Boolean _priceMaterialityIsApplicable) {
			this.priceMaterialityIsApplicable = _priceMaterialityIsApplicable == null ? null : _priceMaterialityIsApplicable;
			return this;
		}
		
		@RosettaAttribute("escrowArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("escrowArrangement")
		@Override
		public PriceMateriality.PriceMaterialityBuilder setEscrowArrangement(EscrowArrangement _escrowArrangement) {
			this.escrowArrangement = _escrowArrangement == null ? null : _escrowArrangement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fallbackReferencePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackReferencePrice")
		@Override
		public PriceMateriality.PriceMaterialityBuilder setFallbackReferencePrice(SettlementRateOption _fallbackReferencePrice) {
			this.fallbackReferencePrice = _fallbackReferencePrice == null ? null : _fallbackReferencePrice.toBuilder();
			return this;
		}
		
		@Override
		public PriceMateriality build() {
			return new PriceMateriality.PriceMaterialityImpl(this);
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceMateriality.PriceMaterialityBuilder prune() {
			if (escrowArrangement!=null && !escrowArrangement.prune().hasData()) escrowArrangement = null;
			if (fallbackReferencePrice!=null && !fallbackReferencePrice.prune().hasData()) fallbackReferencePrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPriceMaterialityIsApplicable()!=null) return true;
			if (getEscrowArrangement()!=null && getEscrowArrangement().hasData()) return true;
			if (getFallbackReferencePrice()!=null && getFallbackReferencePrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceMateriality.PriceMaterialityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceMateriality.PriceMaterialityBuilder o = (PriceMateriality.PriceMaterialityBuilder) other;
			
			merger.mergeRosetta(getEscrowArrangement(), o.getEscrowArrangement(), this::setEscrowArrangement);
			merger.mergeRosetta(getFallbackReferencePrice(), o.getFallbackReferencePrice(), this::setFallbackReferencePrice);
			
			merger.mergeBasic(getPriceMaterialityIsApplicable(), o.getPriceMaterialityIsApplicable(), this::setPriceMaterialityIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceMateriality _that = getType().cast(o);
		
			if (!Objects.equals(priceMaterialityIsApplicable, _that.getPriceMaterialityIsApplicable())) return false;
			if (!Objects.equals(escrowArrangement, _that.getEscrowArrangement())) return false;
			if (!Objects.equals(fallbackReferencePrice, _that.getFallbackReferencePrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceMaterialityIsApplicable != null ? priceMaterialityIsApplicable.hashCode() : 0);
			_result = 31 * _result + (escrowArrangement != null ? escrowArrangement.hashCode() : 0);
			_result = 31 * _result + (fallbackReferencePrice != null ? fallbackReferencePrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceMaterialityBuilder {" +
				"priceMaterialityIsApplicable=" + this.priceMaterialityIsApplicable + ", " +
				"escrowArrangement=" + this.escrowArrangement + ", " +
				"fallbackReferencePrice=" + this.fallbackReferencePrice +
			'}';
		}
	}
}
