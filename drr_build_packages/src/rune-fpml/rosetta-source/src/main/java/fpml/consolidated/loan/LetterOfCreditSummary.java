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
import fpml.consolidated.loan.meta.LetterOfCreditSummaryMeta;
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
 * Provision A short form definition of a letter of credit.
 *
 */
@RosettaDataType(value="LetterOfCreditSummary", builder=LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LetterOfCreditSummary", model="fpml", builder=LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl.class, version="2.1.1")
public interface LetterOfCreditSummary extends LoanContractIdentifier {

	LetterOfCreditSummaryMeta metaData = new LetterOfCreditSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The letter of credit type for which a fee rate is being provided.
	 *
	 */
	LcType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Effective date of the letter of credit.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Main borrower.
	 *
	 */
	PartyReference getBorrowerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party references to any letter of credit issuers associated with the facility borrower.
	 *
	 */
	PartyReference getIssuingBankPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party reference of the beneficiary.
	 *
	 */
	PartyReference getBeneficiaryPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The letter of credit notional amount. The amount is represented at the global and (optionally) at the lender-specific level.
	 *
	 */
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	LetterOfCreditSummary build();
	
	LetterOfCreditSummary.LetterOfCreditSummaryBuilder toBuilder();
	
	static LetterOfCreditSummary.LetterOfCreditSummaryBuilder builder() {
		return new LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCreditSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LetterOfCreditSummary> getType() {
		return LetterOfCreditSummary.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface LetterOfCreditSummaryBuilder extends LetterOfCreditSummary, LoanContractIdentifier.LoanContractIdentifierBuilder {
		LcType.LcTypeBuilder getOrCreateType();
		@Override
		LcType.LcTypeBuilder _getType();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateIssuingBankPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getIssuingBankPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setId(String id);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addContractId(ContractId contractId);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addContractId(ContractId contractId, int idx);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addContractId(List<? extends ContractId> contractId);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setContractId(List<? extends ContractId> contractId);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addVersionedContractId(VersionedContractId versionedContractId);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addVersionedContractId(VersionedContractId versionedContractId, int idx);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setFacilityReference(FacilityReference facilityReference);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setType(LcType type);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setIssuingBankPartyReference(PartyReference issuingBankPartyReference);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setBeneficiaryPartyReference(PartyReference beneficiaryPartyReference);
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder setAmount(MoneyWithParticipantShare amount);

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
		}
		

		LetterOfCreditSummary.LetterOfCreditSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCreditSummary  ***********************/
	class LetterOfCreditSummaryImpl extends LoanContractIdentifier.LoanContractIdentifierImpl implements LetterOfCreditSummary {
		private final LcType type;
		private final ZonedDateTime effectiveDate;
		private final PartyReference borrowerPartyReference;
		private final PartyReference issuingBankPartyReference;
		private final PartyReference beneficiaryPartyReference;
		private final MoneyWithParticipantShare amount;
		
		protected LetterOfCreditSummaryImpl(LetterOfCreditSummary.LetterOfCreditSummaryBuilder builder) {
			super(builder);
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
			this.issuingBankPartyReference = ofNullable(builder.getIssuingBankPartyReference()).map(f->f.build()).orElse(null);
			this.beneficiaryPartyReference = ofNullable(builder.getBeneficiaryPartyReference()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LcType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		public PartyReference getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("issuingBankPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("issuingBankPartyReference")
		public PartyReference getIssuingBankPartyReference() {
			return issuingBankPartyReference;
		}
		
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiaryPartyReference")
		public PartyReference getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		public LetterOfCreditSummary build() {
			return this;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder toBuilder() {
			LetterOfCreditSummary.LetterOfCreditSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCreditSummary.LetterOfCreditSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getIssuingBankPartyReference()).ifPresent(builder::setIssuingBankPartyReference);
			ofNullable(getBeneficiaryPartyReference()).ifPresent(builder::setBeneficiaryPartyReference);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LetterOfCreditSummary _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(issuingBankPartyReference, _that.getIssuingBankPartyReference())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (issuingBankPartyReference != null ? issuingBankPartyReference.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditSummary {" +
				"type=" + this.type + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"issuingBankPartyReference=" + this.issuingBankPartyReference + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference + ", " +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LetterOfCreditSummary  ***********************/
	class LetterOfCreditSummaryBuilderImpl extends LoanContractIdentifier.LoanContractIdentifierBuilderImpl implements LetterOfCreditSummary.LetterOfCreditSummaryBuilder {
	
		protected LcType.LcTypeBuilder type;
		protected ZonedDateTime effectiveDate;
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
		protected PartyReference.PartyReferenceBuilder issuingBankPartyReference;
		protected PartyReference.PartyReferenceBuilder beneficiaryPartyReference;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public LcType.LcTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public LcType.LcTypeBuilder getOrCreateType() {
			LcType.LcTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = LcType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		public PartyReference.PartyReferenceBuilder getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (borrowerPartyReference!=null) {
				result = borrowerPartyReference;
			}
			else {
				result = borrowerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuingBankPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("issuingBankPartyReference")
		public PartyReference.PartyReferenceBuilder getIssuingBankPartyReference() {
			return issuingBankPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIssuingBankPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (issuingBankPartyReference!=null) {
				result = issuingBankPartyReference;
			}
			else {
				result = issuingBankPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiaryPartyReference")
		public PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (beneficiaryPartyReference!=null) {
				result = beneficiaryPartyReference;
			}
			else {
				result = beneficiaryPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractId")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addContractId(ContractId _contractId) {
			if (_contractId != null) {
				this.contractId.add(_contractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addContractId(ContractId _contractId, int idx) {
			getIndex(this.contractId, idx, () -> _contractId.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addContractId(List<? extends ContractId> contractIds) {
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
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setContractId(List<? extends ContractId> contractIds) {
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
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addVersionedContractId(VersionedContractId _versionedContractId) {
			if (_versionedContractId != null) {
				this.versionedContractId.add(_versionedContractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addVersionedContractId(VersionedContractId _versionedContractId, int idx) {
			getIndex(this.versionedContractId, idx, () -> _versionedContractId.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setType(LcType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuingBankPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("issuingBankPartyReference")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setIssuingBankPartyReference(PartyReference _issuingBankPartyReference) {
			this.issuingBankPartyReference = _issuingBankPartyReference == null ? null : _issuingBankPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiaryPartyReference")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setBeneficiaryPartyReference(PartyReference _beneficiaryPartyReference) {
			this.beneficiaryPartyReference = _beneficiaryPartyReference == null ? null : _beneficiaryPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCreditSummary build() {
			return new LetterOfCreditSummary.LetterOfCreditSummaryImpl(this);
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			if (issuingBankPartyReference!=null && !issuingBankPartyReference.prune().hasData()) issuingBankPartyReference = null;
			if (beneficiaryPartyReference!=null && !beneficiaryPartyReference.prune().hasData()) beneficiaryPartyReference = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (_getType()!=null && _getType().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			if (getIssuingBankPartyReference()!=null && getIssuingBankPartyReference().hasData()) return true;
			if (getBeneficiaryPartyReference()!=null && getBeneficiaryPartyReference().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LetterOfCreditSummary.LetterOfCreditSummaryBuilder o = (LetterOfCreditSummary.LetterOfCreditSummaryBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			merger.mergeRosetta(getIssuingBankPartyReference(), o.getIssuingBankPartyReference(), this::setIssuingBankPartyReference);
			merger.mergeRosetta(getBeneficiaryPartyReference(), o.getBeneficiaryPartyReference(), this::setBeneficiaryPartyReference);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LetterOfCreditSummary _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(issuingBankPartyReference, _that.getIssuingBankPartyReference())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (issuingBankPartyReference != null ? issuingBankPartyReference.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditSummaryBuilder {" +
				"type=" + this.type + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"issuingBankPartyReference=" + this.issuingBankPartyReference + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference + ", " +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
