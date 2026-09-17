package fpml.consolidated.loan;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.doc.ContractId;
import fpml.consolidated.doc.VersionedContractId;
import fpml.consolidated.fpmlenum.LcAutoAdjustEnum;
import fpml.consolidated.loan.meta.LetterOfCreditMeta;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A definition of an unfunded borrowing (guarantee) instrument known as a Letter of Credit.
 *
 */
@RosettaDataType(value="LetterOfCredit", builder=LetterOfCredit.LetterOfCreditBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LetterOfCredit", model="fpml", builder=LetterOfCredit.LetterOfCreditBuilderImpl.class, version="2.1.1")
public interface LetterOfCredit extends LetterOfCreditSummary {

	LetterOfCreditMeta metaData = new LetterOfCreditMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Expiry date of the letter of credit.
	 *
	 */
	ZonedDateTime getExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Final expiry date of the letter of credit, once the evergreen option has been exercised.
	 *
	 */
	ZonedDateTime getFinalExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The letter of credit fee rate details.
	 *
	 */
	LcAccrual getLcAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the purpose of a letter of credit.
	 *
	 */
	LcPurpose getPurpose();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An option allowing the borrower to extend the letter of credit tenor.
	 *
	 */
	EvergreenOption getEvergreenOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the manner by which a letter of credit may automatically adjust.
	 *
	 */
	LcAutoAdjustEnum getLcAutoAdjust();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The letter of credit notional amount. The amount is represented at the global and (optionally) atthe lender-specific level.
	 *
	 */
	MoneyWithParticipantShare getMinLcIssuanceFeeAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines exchange rate between the letter of credit and facility.
	 *
	 */
	FxTerms getFacilityFxRate();

	/*********************** Build Methods  ***********************/
	LetterOfCredit build();
	
	LetterOfCredit.LetterOfCreditBuilder toBuilder();
	
	static LetterOfCredit.LetterOfCreditBuilder builder() {
		return new LetterOfCredit.LetterOfCreditBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCredit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LetterOfCredit> getType() {
		return LetterOfCredit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("contractId"), processor, ContractId.class, getContractId());
		processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.class, getVersionedContractId());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("type"), processor, LcType.class, _getType());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("issuingBankPartyReference"), processor, PartyReference.class, getIssuingBankPartyReference());
		processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.class, getBeneficiaryPartyReference());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("finalExpiryDate"), ZonedDateTime.class, getFinalExpiryDate(), this);
		processRosetta(path.newSubPath("lcAccrual"), processor, LcAccrual.class, getLcAccrual());
		processRosetta(path.newSubPath("purpose"), processor, LcPurpose.class, getPurpose());
		processRosetta(path.newSubPath("evergreenOption"), processor, EvergreenOption.class, getEvergreenOption());
		processor.processBasic(path.newSubPath("lcAutoAdjust"), LcAutoAdjustEnum.class, getLcAutoAdjust(), this);
		processRosetta(path.newSubPath("minLcIssuanceFeeAmount"), processor, MoneyWithParticipantShare.class, getMinLcIssuanceFeeAmount());
		processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.class, getFacilityFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LetterOfCreditBuilder extends LetterOfCredit, LetterOfCreditSummary.LetterOfCreditSummaryBuilder {
		LcAccrual.LcAccrualBuilder getOrCreateLcAccrual();
		@Override
		LcAccrual.LcAccrualBuilder getLcAccrual();
		LcPurpose.LcPurposeBuilder getOrCreatePurpose();
		@Override
		LcPurpose.LcPurposeBuilder getPurpose();
		EvergreenOption.EvergreenOptionBuilder getOrCreateEvergreenOption();
		@Override
		EvergreenOption.EvergreenOptionBuilder getEvergreenOption();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateMinLcIssuanceFeeAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getMinLcIssuanceFeeAmount();
		FxTerms.FxTermsBuilder getOrCreateFacilityFxRate();
		@Override
		FxTerms.FxTermsBuilder getFacilityFxRate();
		@Override
		LetterOfCredit.LetterOfCreditBuilder setId(String id);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setPartyReference(PartyReference partyReference);
		@Override
		LetterOfCredit.LetterOfCreditBuilder addContractId(ContractId contractId);
		@Override
		LetterOfCredit.LetterOfCreditBuilder addContractId(ContractId contractId, int idx);
		@Override
		LetterOfCredit.LetterOfCreditBuilder addContractId(List<? extends ContractId> contractId);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setContractId(List<? extends ContractId> contractId);
		@Override
		LetterOfCredit.LetterOfCreditBuilder addVersionedContractId(VersionedContractId versionedContractId);
		@Override
		LetterOfCredit.LetterOfCreditBuilder addVersionedContractId(VersionedContractId versionedContractId, int idx);
		@Override
		LetterOfCredit.LetterOfCreditBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setType(LcType type);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setIssuingBankPartyReference(PartyReference issuingBankPartyReference);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setBeneficiaryPartyReference(PartyReference beneficiaryPartyReference);
		@Override
		LetterOfCredit.LetterOfCreditBuilder setAmount(MoneyWithParticipantShare amount);
		LetterOfCredit.LetterOfCreditBuilder setExpiryDate(ZonedDateTime expiryDate);
		LetterOfCredit.LetterOfCreditBuilder setFinalExpiryDate(ZonedDateTime finalExpiryDate);
		LetterOfCredit.LetterOfCreditBuilder setLcAccrual(LcAccrual lcAccrual);
		LetterOfCredit.LetterOfCreditBuilder setPurpose(LcPurpose purpose);
		LetterOfCredit.LetterOfCreditBuilder setEvergreenOption(EvergreenOption evergreenOption);
		LetterOfCredit.LetterOfCreditBuilder setLcAutoAdjust(LcAutoAdjustEnum lcAutoAdjust);
		LetterOfCredit.LetterOfCreditBuilder setMinLcIssuanceFeeAmount(MoneyWithParticipantShare minLcIssuanceFeeAmount);
		LetterOfCredit.LetterOfCreditBuilder setFacilityFxRate(FxTerms facilityFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("contractId"), processor, ContractId.ContractIdBuilder.class, getContractId());
			processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.VersionedContractIdBuilder.class, getVersionedContractId());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("type"), processor, LcType.LcTypeBuilder.class, _getType());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("issuingBankPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIssuingBankPartyReference());
			processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBeneficiaryPartyReference());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("finalExpiryDate"), ZonedDateTime.class, getFinalExpiryDate(), this);
			processRosetta(path.newSubPath("lcAccrual"), processor, LcAccrual.LcAccrualBuilder.class, getLcAccrual());
			processRosetta(path.newSubPath("purpose"), processor, LcPurpose.LcPurposeBuilder.class, getPurpose());
			processRosetta(path.newSubPath("evergreenOption"), processor, EvergreenOption.EvergreenOptionBuilder.class, getEvergreenOption());
			processor.processBasic(path.newSubPath("lcAutoAdjust"), LcAutoAdjustEnum.class, getLcAutoAdjust(), this);
			processRosetta(path.newSubPath("minLcIssuanceFeeAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getMinLcIssuanceFeeAmount());
			processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.FxTermsBuilder.class, getFacilityFxRate());
		}
		

		LetterOfCredit.LetterOfCreditBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCredit  ***********************/
	class LetterOfCreditImpl extends LetterOfCreditSummary.LetterOfCreditSummaryImpl implements LetterOfCredit {
		private final ZonedDateTime expiryDate;
		private final ZonedDateTime finalExpiryDate;
		private final LcAccrual lcAccrual;
		private final LcPurpose purpose;
		private final EvergreenOption evergreenOption;
		private final LcAutoAdjustEnum lcAutoAdjust;
		private final MoneyWithParticipantShare minLcIssuanceFeeAmount;
		private final FxTerms facilityFxRate;
		
		protected LetterOfCreditImpl(LetterOfCredit.LetterOfCreditBuilder builder) {
			super(builder);
			this.expiryDate = builder.getExpiryDate();
			this.finalExpiryDate = builder.getFinalExpiryDate();
			this.lcAccrual = ofNullable(builder.getLcAccrual()).map(f->f.build()).orElse(null);
			this.purpose = ofNullable(builder.getPurpose()).map(f->f.build()).orElse(null);
			this.evergreenOption = ofNullable(builder.getEvergreenOption()).map(f->f.build()).orElse(null);
			this.lcAutoAdjust = builder.getLcAutoAdjust();
			this.minLcIssuanceFeeAmount = ofNullable(builder.getMinLcIssuanceFeeAmount()).map(f->f.build()).orElse(null);
			this.facilityFxRate = ofNullable(builder.getFacilityFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalExpiryDate")
		public ZonedDateTime getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("lcAccrual")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lcAccrual")
		public LcAccrual getLcAccrual() {
			return lcAccrual;
		}
		
		@Override
		@RosettaAttribute("purpose")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("purpose")
		public LcPurpose getPurpose() {
			return purpose;
		}
		
		@Override
		@RosettaAttribute("evergreenOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("evergreenOption")
		public EvergreenOption getEvergreenOption() {
			return evergreenOption;
		}
		
		@Override
		@RosettaAttribute("lcAutoAdjust")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcAutoAdjust")
		public LcAutoAdjustEnum getLcAutoAdjust() {
			return lcAutoAdjust;
		}
		
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minLcIssuanceFeeAmount")
		public MoneyWithParticipantShare getMinLcIssuanceFeeAmount() {
			return minLcIssuanceFeeAmount;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityFxRate")
		public FxTerms getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public LetterOfCredit build() {
			return this;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder toBuilder() {
			LetterOfCredit.LetterOfCreditBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCredit.LetterOfCreditBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getFinalExpiryDate()).ifPresent(builder::setFinalExpiryDate);
			ofNullable(getLcAccrual()).ifPresent(builder::setLcAccrual);
			ofNullable(getPurpose()).ifPresent(builder::setPurpose);
			ofNullable(getEvergreenOption()).ifPresent(builder::setEvergreenOption);
			ofNullable(getLcAutoAdjust()).ifPresent(builder::setLcAutoAdjust);
			ofNullable(getMinLcIssuanceFeeAmount()).ifPresent(builder::setMinLcIssuanceFeeAmount);
			ofNullable(getFacilityFxRate()).ifPresent(builder::setFacilityFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LetterOfCredit _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(lcAccrual, _that.getLcAccrual())) return false;
			if (!Objects.equals(purpose, _that.getPurpose())) return false;
			if (!Objects.equals(evergreenOption, _that.getEvergreenOption())) return false;
			if (!Objects.equals(lcAutoAdjust, _that.getLcAutoAdjust())) return false;
			if (!Objects.equals(minLcIssuanceFeeAmount, _that.getMinLcIssuanceFeeAmount())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (lcAccrual != null ? lcAccrual.hashCode() : 0);
			_result = 31 * _result + (purpose != null ? purpose.hashCode() : 0);
			_result = 31 * _result + (evergreenOption != null ? evergreenOption.hashCode() : 0);
			_result = 31 * _result + (lcAutoAdjust != null ? lcAutoAdjust.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (minLcIssuanceFeeAmount != null ? minLcIssuanceFeeAmount.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCredit {" +
				"expiryDate=" + this.expiryDate + ", " +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"lcAccrual=" + this.lcAccrual + ", " +
				"purpose=" + this.purpose + ", " +
				"evergreenOption=" + this.evergreenOption + ", " +
				"lcAutoAdjust=" + this.lcAutoAdjust + ", " +
				"minLcIssuanceFeeAmount=" + this.minLcIssuanceFeeAmount + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LetterOfCredit  ***********************/
	class LetterOfCreditBuilderImpl extends LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl implements LetterOfCredit.LetterOfCreditBuilder {
	
		protected ZonedDateTime expiryDate;
		protected ZonedDateTime finalExpiryDate;
		protected LcAccrual.LcAccrualBuilder lcAccrual;
		protected LcPurpose.LcPurposeBuilder purpose;
		protected EvergreenOption.EvergreenOptionBuilder evergreenOption;
		protected LcAutoAdjustEnum lcAutoAdjust;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder minLcIssuanceFeeAmount;
		protected FxTerms.FxTermsBuilder facilityFxRate;
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalExpiryDate")
		public ZonedDateTime getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("lcAccrual")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lcAccrual")
		public LcAccrual.LcAccrualBuilder getLcAccrual() {
			return lcAccrual;
		}
		
		@Override
		public LcAccrual.LcAccrualBuilder getOrCreateLcAccrual() {
			LcAccrual.LcAccrualBuilder result;
			if (lcAccrual!=null) {
				result = lcAccrual;
			}
			else {
				result = lcAccrual = LcAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("purpose")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("purpose")
		public LcPurpose.LcPurposeBuilder getPurpose() {
			return purpose;
		}
		
		@Override
		public LcPurpose.LcPurposeBuilder getOrCreatePurpose() {
			LcPurpose.LcPurposeBuilder result;
			if (purpose!=null) {
				result = purpose;
			}
			else {
				result = purpose = LcPurpose.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("evergreenOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("evergreenOption")
		public EvergreenOption.EvergreenOptionBuilder getEvergreenOption() {
			return evergreenOption;
		}
		
		@Override
		public EvergreenOption.EvergreenOptionBuilder getOrCreateEvergreenOption() {
			EvergreenOption.EvergreenOptionBuilder result;
			if (evergreenOption!=null) {
				result = evergreenOption;
			}
			else {
				result = evergreenOption = EvergreenOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcAutoAdjust")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcAutoAdjust")
		public LcAutoAdjustEnum getLcAutoAdjust() {
			return lcAutoAdjust;
		}
		
		@Override
		@RosettaAttribute("minLcIssuanceFeeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minLcIssuanceFeeAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getMinLcIssuanceFeeAmount() {
			return minLcIssuanceFeeAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateMinLcIssuanceFeeAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (minLcIssuanceFeeAmount!=null) {
				result = minLcIssuanceFeeAmount;
			}
			else {
				result = minLcIssuanceFeeAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityFxRate")
		public FxTerms.FxTermsBuilder getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateFacilityFxRate() {
			FxTerms.FxTermsBuilder result;
			if (facilityFxRate!=null) {
				result = facilityFxRate;
			}
			else {
				result = facilityFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractId")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder addContractId(ContractId _contractId) {
			if (_contractId != null) {
				this.contractId.add(_contractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder addContractId(ContractId _contractId, int idx) {
			getIndex(this.contractId, idx, () -> _contractId.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder addContractId(List<? extends ContractId> contractIds) {
			if (contractIds != null) {
				for (final ContractId toAdd : contractIds) {
					this.contractId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contractId")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setContractId(List<? extends ContractId> contractIds) {
			if (contractIds == null) {
				this.contractId = new ArrayList<>();
			} else {
				this.contractId = contractIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("versionedContractId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("versionedContractId")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder addVersionedContractId(VersionedContractId _versionedContractId) {
			if (_versionedContractId != null) {
				this.versionedContractId.add(_versionedContractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder addVersionedContractId(VersionedContractId _versionedContractId, int idx) {
			getIndex(this.versionedContractId, idx, () -> _versionedContractId.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
			if (versionedContractIds != null) {
				for (final VersionedContractId toAdd : versionedContractIds) {
					this.versionedContractId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("versionedContractId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("versionedContractId")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
			if (versionedContractIds == null) {
				this.versionedContractId = new ArrayList<>();
			} else {
				this.versionedContractId = versionedContractIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setType(LcType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuingBankPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("issuingBankPartyReference")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setIssuingBankPartyReference(PartyReference _issuingBankPartyReference) {
			this.issuingBankPartyReference = _issuingBankPartyReference == null ? null : _issuingBankPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiaryPartyReference")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setBeneficiaryPartyReference(PartyReference _beneficiaryPartyReference) {
			this.beneficiaryPartyReference = _beneficiaryPartyReference == null ? null : _beneficiaryPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expiryDate")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalExpiryDate")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setFinalExpiryDate(ZonedDateTime _finalExpiryDate) {
			this.finalExpiryDate = _finalExpiryDate == null ? null : _finalExpiryDate;
			return this;
		}
		
		@RosettaAttribute("lcAccrual")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lcAccrual")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setLcAccrual(LcAccrual _lcAccrual) {
			this.lcAccrual = _lcAccrual == null ? null : _lcAccrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("purpose")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("purpose")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setPurpose(LcPurpose _purpose) {
			this.purpose = _purpose == null ? null : _purpose.toBuilder();
			return this;
		}
		
		@RosettaAttribute("evergreenOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("evergreenOption")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setEvergreenOption(EvergreenOption _evergreenOption) {
			this.evergreenOption = _evergreenOption == null ? null : _evergreenOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcAutoAdjust")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcAutoAdjust")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setLcAutoAdjust(LcAutoAdjustEnum _lcAutoAdjust) {
			this.lcAutoAdjust = _lcAutoAdjust == null ? null : _lcAutoAdjust;
			return this;
		}
		
		@RosettaAttribute("minLcIssuanceFeeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minLcIssuanceFeeAmount")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setMinLcIssuanceFeeAmount(MoneyWithParticipantShare _minLcIssuanceFeeAmount) {
			this.minLcIssuanceFeeAmount = _minLcIssuanceFeeAmount == null ? null : _minLcIssuanceFeeAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityFxRate")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder setFacilityFxRate(FxTerms _facilityFxRate) {
			this.facilityFxRate = _facilityFxRate == null ? null : _facilityFxRate.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCredit build() {
			return new LetterOfCredit.LetterOfCreditImpl(this);
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder prune() {
			super.prune();
			if (lcAccrual!=null && !lcAccrual.prune().hasData()) lcAccrual = null;
			if (purpose!=null && !purpose.prune().hasData()) purpose = null;
			if (evergreenOption!=null && !evergreenOption.prune().hasData()) evergreenOption = null;
			if (minLcIssuanceFeeAmount!=null && !minLcIssuanceFeeAmount.prune().hasData()) minLcIssuanceFeeAmount = null;
			if (facilityFxRate!=null && !facilityFxRate.prune().hasData()) facilityFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpiryDate()!=null) return true;
			if (getFinalExpiryDate()!=null) return true;
			if (getLcAccrual()!=null && getLcAccrual().hasData()) return true;
			if (getPurpose()!=null && getPurpose().hasData()) return true;
			if (getEvergreenOption()!=null && getEvergreenOption().hasData()) return true;
			if (getLcAutoAdjust()!=null) return true;
			if (getMinLcIssuanceFeeAmount()!=null && getMinLcIssuanceFeeAmount().hasData()) return true;
			if (getFacilityFxRate()!=null && getFacilityFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LetterOfCredit.LetterOfCreditBuilder o = (LetterOfCredit.LetterOfCreditBuilder) other;
			
			merger.mergeRosetta(getLcAccrual(), o.getLcAccrual(), this::setLcAccrual);
			merger.mergeRosetta(getPurpose(), o.getPurpose(), this::setPurpose);
			merger.mergeRosetta(getEvergreenOption(), o.getEvergreenOption(), this::setEvergreenOption);
			merger.mergeRosetta(getMinLcIssuanceFeeAmount(), o.getMinLcIssuanceFeeAmount(), this::setMinLcIssuanceFeeAmount);
			merger.mergeRosetta(getFacilityFxRate(), o.getFacilityFxRate(), this::setFacilityFxRate);
			
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getFinalExpiryDate(), o.getFinalExpiryDate(), this::setFinalExpiryDate);
			merger.mergeBasic(getLcAutoAdjust(), o.getLcAutoAdjust(), this::setLcAutoAdjust);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LetterOfCredit _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(lcAccrual, _that.getLcAccrual())) return false;
			if (!Objects.equals(purpose, _that.getPurpose())) return false;
			if (!Objects.equals(evergreenOption, _that.getEvergreenOption())) return false;
			if (!Objects.equals(lcAutoAdjust, _that.getLcAutoAdjust())) return false;
			if (!Objects.equals(minLcIssuanceFeeAmount, _that.getMinLcIssuanceFeeAmount())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (lcAccrual != null ? lcAccrual.hashCode() : 0);
			_result = 31 * _result + (purpose != null ? purpose.hashCode() : 0);
			_result = 31 * _result + (evergreenOption != null ? evergreenOption.hashCode() : 0);
			_result = 31 * _result + (lcAutoAdjust != null ? lcAutoAdjust.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (minLcIssuanceFeeAmount != null ? minLcIssuanceFeeAmount.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditBuilder {" +
				"expiryDate=" + this.expiryDate + ", " +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"lcAccrual=" + this.lcAccrual + ", " +
				"purpose=" + this.purpose + ", " +
				"evergreenOption=" + this.evergreenOption + ", " +
				"lcAutoAdjust=" + this.lcAutoAdjust + ", " +
				"minLcIssuanceFeeAmount=" + this.minLcIssuanceFeeAmount + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}
}
