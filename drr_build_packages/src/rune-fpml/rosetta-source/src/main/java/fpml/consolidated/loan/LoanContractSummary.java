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
import fpml.consolidated.loan.meta.LoanContractSummaryMeta;
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
 * Provision A short form of a loan contract.
 *
 */
@RosettaDataType(value="LoanContractSummary", builder=LoanContractSummary.LoanContractSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContractSummary", model="fpml", builder=LoanContractSummary.LoanContractSummaryBuilderImpl.class, version="2.1.1")
public interface LoanContractSummary extends LoanContractIdentifier {

	LoanContractSummaryMeta metaData = new LoanContractSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The effective date of the loan contract. This is the date on which the funds are passed to the borrower. It is an actual (adjusted) date.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the borrower against a loan contract.
	 *
	 */
	PartyReference getBorrowerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party references to any guarantors associated with the facility borrower.
	 *
	 */
	PartyReference getGuarantorPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	LoanContractSummary build();
	
	LoanContractSummary.LoanContractSummaryBuilder toBuilder();
	
	static LoanContractSummary.LoanContractSummaryBuilder builder() {
		return new LoanContractSummary.LoanContractSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContractSummary> getType() {
		return LoanContractSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("contractId"), processor, ContractId.class, getContractId());
		processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.class, getVersionedContractId());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractSummaryBuilder extends LoanContractSummary, LoanContractIdentifier.LoanContractIdentifierBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getGuarantorPartyReference();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		@Override
		LoanContractSummary.LoanContractSummaryBuilder setId(String id);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder addContractId(ContractId contractId);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder addContractId(ContractId contractId, int idx);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder addContractId(List<? extends ContractId> contractId);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder setContractId(List<? extends ContractId> contractId);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder addVersionedContractId(VersionedContractId versionedContractId);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder addVersionedContractId(VersionedContractId versionedContractId, int idx);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LoanContractSummary.LoanContractSummaryBuilder setFacilityReference(FacilityReference facilityReference);
		LoanContractSummary.LoanContractSummaryBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		LoanContractSummary.LoanContractSummaryBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		LoanContractSummary.LoanContractSummaryBuilder setGuarantorPartyReference(PartyReference guarantorPartyReference);
		LoanContractSummary.LoanContractSummaryBuilder setAmount(MoneyWithParticipantShare amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("contractId"), processor, ContractId.ContractIdBuilder.class, getContractId());
			processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.VersionedContractIdBuilder.class, getVersionedContractId());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		LoanContractSummary.LoanContractSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractSummary  ***********************/
	class LoanContractSummaryImpl extends LoanContractIdentifier.LoanContractIdentifierImpl implements LoanContractSummary {
		private final ZonedDateTime effectiveDate;
		private final PartyReference borrowerPartyReference;
		private final PartyReference guarantorPartyReference;
		private final MoneyWithParticipantShare amount;
		
		protected LoanContractSummaryImpl(LoanContractSummary.LoanContractSummaryBuilder builder) {
			super(builder);
			this.effectiveDate = builder.getEffectiveDate();
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
			this.guarantorPartyReference = ofNullable(builder.getGuarantorPartyReference()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("guarantorPartyReference")
		public PartyReference getGuarantorPartyReference() {
			return guarantorPartyReference;
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
		public LoanContractSummary build() {
			return this;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder toBuilder() {
			LoanContractSummary.LoanContractSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractSummary.LoanContractSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getGuarantorPartyReference()).ifPresent(builder::setGuarantorPartyReference);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractSummary _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractSummary {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractSummary  ***********************/
	class LoanContractSummaryBuilderImpl extends LoanContractIdentifier.LoanContractIdentifierBuilderImpl implements LoanContractSummary.LoanContractSummaryBuilder {
	
		protected ZonedDateTime effectiveDate;
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
		protected PartyReference.PartyReferenceBuilder guarantorPartyReference;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		
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
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("guarantorPartyReference")
		public PartyReference.PartyReferenceBuilder getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (guarantorPartyReference!=null) {
				result = guarantorPartyReference;
			}
			else {
				result = guarantorPartyReference = PartyReference.builder();
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
		public LoanContractSummary.LoanContractSummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractId")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder addContractId(ContractId _contractId) {
			if (_contractId != null) {
				this.contractId.add(_contractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder addContractId(ContractId _contractId, int idx) {
			getIndex(this.contractId, idx, () -> _contractId.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder addContractId(List<? extends ContractId> contractIds) {
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
		public LoanContractSummary.LoanContractSummaryBuilder setContractId(List<? extends ContractId> contractIds) {
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
		public LoanContractSummary.LoanContractSummaryBuilder addVersionedContractId(VersionedContractId _versionedContractId) {
			if (_versionedContractId != null) {
				this.versionedContractId.add(_versionedContractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder addVersionedContractId(VersionedContractId _versionedContractId, int idx) {
			getIndex(this.versionedContractId, idx, () -> _versionedContractId.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public LoanContractSummary.LoanContractSummaryBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public LoanContractSummary.LoanContractSummaryBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("guarantorPartyReference")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder setGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			this.guarantorPartyReference = _guarantorPartyReference == null ? null : _guarantorPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@Override
		public LoanContractSummary build() {
			return new LoanContractSummary.LoanContractSummaryImpl(this);
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder prune() {
			super.prune();
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			if (guarantorPartyReference!=null && !guarantorPartyReference.prune().hasData()) guarantorPartyReference = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			if (getGuarantorPartyReference()!=null && getGuarantorPartyReference().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanContractSummary.LoanContractSummaryBuilder o = (LoanContractSummary.LoanContractSummaryBuilder) other;
			
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			merger.mergeRosetta(getGuarantorPartyReference(), o.getGuarantorPartyReference(), this::setGuarantorPartyReference);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractSummary _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractSummaryBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
