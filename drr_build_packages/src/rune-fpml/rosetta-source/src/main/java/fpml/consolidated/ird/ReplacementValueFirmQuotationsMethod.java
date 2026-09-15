package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.ReplacementValueFirmQuotationsMethodMeta;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This type is a specific type holding the data fields for the replacement value firm quotations cash settlement method described in the 2021 ISDA Definitions, section 18.2.4. It adds an additional field to the shared replacement value data fields.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This type is a specific type holding the data fields for the replacement value firm quotations cash settlement method described in the 2021 ISDA Definitions, section 18.2.4. It adds an additional field to the shared replacement value data fields.
 *
 */
@RosettaDataType(value="ReplacementValueFirmQuotationsMethod", builder=ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReplacementValueFirmQuotationsMethod", model="fpml", builder=ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilderImpl.class, version="2.1.1")
public interface ReplacementValueFirmQuotationsMethod extends ReplacementValueMethodBase {

	ReplacementValueFirmQuotationsMethodMeta metaData = new ReplacementValueFirmQuotationsMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to indicate that "prescribed documentation adjustment" is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to indicate that "prescribed documentation adjustment" is applicable.
	 *
	 */
	Boolean getPrescribedDocumentationAdjustment();

	/*********************** Build Methods  ***********************/
	ReplacementValueFirmQuotationsMethod build();
	
	ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder toBuilder();
	
	static ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder builder() {
		return new ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReplacementValueFirmQuotationsMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReplacementValueFirmQuotationsMethod> getType() {
		return ReplacementValueFirmQuotationsMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.class, getCashSettlementCurrency());
		processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.class, getCashSettlementReferenceBanks());
		processRosetta(path.newSubPath("protectedParty"), processor, PartySelector.class, getProtectedParty());
		processRosetta(path.newSubPath("cashCollateralCurrency"), processor, Currency.class, getCashCollateralCurrency());
		processor.processBasic(path.newSubPath("prescribedDocumentationAdjustment"), Boolean.class, getPrescribedDocumentationAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReplacementValueFirmQuotationsMethodBuilder extends ReplacementValueFirmQuotationsMethod, ReplacementValueMethodBase.ReplacementValueMethodBaseBuilder {
		@Override
		ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setCashSettlementCurrency(Currency cashSettlementCurrency);
		@Override
		ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks cashSettlementReferenceBanks);
		@Override
		ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setProtectedParty(PartySelector protectedParty);
		@Override
		ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setCashCollateralCurrency(Currency cashCollateralCurrency);
		ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setPrescribedDocumentationAdjustment(Boolean prescribedDocumentationAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementCurrency"), processor, Currency.CurrencyBuilder.class, getCashSettlementCurrency());
			processRosetta(path.newSubPath("cashSettlementReferenceBanks"), processor, CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder.class, getCashSettlementReferenceBanks());
			processRosetta(path.newSubPath("protectedParty"), processor, PartySelector.PartySelectorBuilder.class, getProtectedParty());
			processRosetta(path.newSubPath("cashCollateralCurrency"), processor, Currency.CurrencyBuilder.class, getCashCollateralCurrency());
			processor.processBasic(path.newSubPath("prescribedDocumentationAdjustment"), Boolean.class, getPrescribedDocumentationAdjustment(), this);
		}
		

		ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder prune();
	}

	/*********************** Immutable Implementation of ReplacementValueFirmQuotationsMethod  ***********************/
	class ReplacementValueFirmQuotationsMethodImpl extends ReplacementValueMethodBase.ReplacementValueMethodBaseImpl implements ReplacementValueFirmQuotationsMethod {
		private final Boolean prescribedDocumentationAdjustment;
		
		protected ReplacementValueFirmQuotationsMethodImpl(ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder builder) {
			super(builder);
			this.prescribedDocumentationAdjustment = builder.getPrescribedDocumentationAdjustment();
		}
		
		@Override
		@RosettaAttribute("prescribedDocumentationAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prescribedDocumentationAdjustment")
		public Boolean getPrescribedDocumentationAdjustment() {
			return prescribedDocumentationAdjustment;
		}
		
		@Override
		public ReplacementValueFirmQuotationsMethod build() {
			return this;
		}
		
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder toBuilder() {
			ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPrescribedDocumentationAdjustment()).ifPresent(builder::setPrescribedDocumentationAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReplacementValueFirmQuotationsMethod _that = getType().cast(o);
		
			if (!Objects.equals(prescribedDocumentationAdjustment, _that.getPrescribedDocumentationAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (prescribedDocumentationAdjustment != null ? prescribedDocumentationAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReplacementValueFirmQuotationsMethod {" +
				"prescribedDocumentationAdjustment=" + this.prescribedDocumentationAdjustment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReplacementValueFirmQuotationsMethod  ***********************/
	class ReplacementValueFirmQuotationsMethodBuilderImpl extends ReplacementValueMethodBase.ReplacementValueMethodBaseBuilderImpl implements ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder {
	
		protected Boolean prescribedDocumentationAdjustment;
		
		@Override
		@RosettaAttribute("prescribedDocumentationAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prescribedDocumentationAdjustment")
		public Boolean getPrescribedDocumentationAdjustment() {
			return prescribedDocumentationAdjustment;
		}
		
		@RosettaAttribute("cashSettlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementCurrency")
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setCashSettlementCurrency(Currency _cashSettlementCurrency) {
			this.cashSettlementCurrency = _cashSettlementCurrency == null ? null : _cashSettlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlementReferenceBanks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementReferenceBanks")
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setCashSettlementReferenceBanks(CashSettlementReferenceBanks _cashSettlementReferenceBanks) {
			this.cashSettlementReferenceBanks = _cashSettlementReferenceBanks == null ? null : _cashSettlementReferenceBanks.toBuilder();
			return this;
		}
		
		@RosettaAttribute("protectedParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("protectedParty")
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setProtectedParty(PartySelector _protectedParty) {
			this.protectedParty = _protectedParty == null ? null : _protectedParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashCollateralCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashCollateralCurrency")
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setCashCollateralCurrency(Currency _cashCollateralCurrency) {
			this.cashCollateralCurrency = _cashCollateralCurrency == null ? null : _cashCollateralCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prescribedDocumentationAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prescribedDocumentationAdjustment")
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder setPrescribedDocumentationAdjustment(Boolean _prescribedDocumentationAdjustment) {
			this.prescribedDocumentationAdjustment = _prescribedDocumentationAdjustment == null ? null : _prescribedDocumentationAdjustment;
			return this;
		}
		
		@Override
		public ReplacementValueFirmQuotationsMethod build() {
			return new ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodImpl(this);
		}
		
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPrescribedDocumentationAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder o = (ReplacementValueFirmQuotationsMethod.ReplacementValueFirmQuotationsMethodBuilder) other;
			
			
			merger.mergeBasic(getPrescribedDocumentationAdjustment(), o.getPrescribedDocumentationAdjustment(), this::setPrescribedDocumentationAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReplacementValueFirmQuotationsMethod _that = getType().cast(o);
		
			if (!Objects.equals(prescribedDocumentationAdjustment, _that.getPrescribedDocumentationAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (prescribedDocumentationAdjustment != null ? prescribedDocumentationAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReplacementValueFirmQuotationsMethodBuilder {" +
				"prescribedDocumentationAdjustment=" + this.prescribedDocumentationAdjustment +
			'}' + " " + super.toString();
		}
	}
}
