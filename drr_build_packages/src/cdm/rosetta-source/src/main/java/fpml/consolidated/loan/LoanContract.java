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
import fpml.consolidated.loan.meta.LoanContractMeta;
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
 * Provision A funded borrowing instrument which utilizes a portion of an available under a single facility (line of credit) within a bank deal (credit agreement).
 *
 */
@RosettaDataType(value="LoanContract", builder=LoanContract.LoanContractBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContract", model="fpml", builder=LoanContract.LoanContractBuilderImpl.class, version="2.1.1")
public interface LoanContract extends LoanContractSummary {

	LoanContractMeta metaData = new LoanContractMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The repricing date of the loan contract. In the case of a PRIME-based loan, this field should be set to the maturity date of the facility.
	 *
	 */
	ZonedDateTime getRepricingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maturity date of the loan contract. In the case of a PRIME-based loan, this field should be set to the maturity date of the facility.
	 *
	 */
	ZonedDateTime getMaturityDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the base rate and additional charges associated with the loan contract.
	 *
	 */
	FixedRateAccrual getFixedRateAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defined the base rate and additional charges associated with a loan contract
	 *
	 */
	LoanFloatingRateAccrual getFloatingRateAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the base rate and additional charges associated with the loan contract.
	 *
	 */
	LegacyFloatingRateAccrual getLegacyFloatingRateAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines a single (current) FX rate used to calculate utilization in the facility currency. Used in the case where the loan contract currency is different to the facility currency.
	 *
	 */
	FxTerms getFacilityFxRate();

	/*********************** Build Methods  ***********************/
	LoanContract build();
	
	LoanContract.LoanContractBuilder toBuilder();
	
	static LoanContract.LoanContractBuilder builder() {
		return new LoanContract.LoanContractBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContract> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContract> getType() {
		return LoanContract.class;
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
		processor.processBasic(path.newSubPath("repricingDate"), ZonedDateTime.class, getRepricingDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
		processRosetta(path.newSubPath("fixedRateAccrual"), processor, FixedRateAccrual.class, getFixedRateAccrual());
		processRosetta(path.newSubPath("floatingRateAccrual"), processor, LoanFloatingRateAccrual.class, getFloatingRateAccrual());
		processRosetta(path.newSubPath("legacyFloatingRateAccrual"), processor, LegacyFloatingRateAccrual.class, getLegacyFloatingRateAccrual());
		processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.class, getFacilityFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractBuilder extends LoanContract, LoanContractSummary.LoanContractSummaryBuilder {
		FixedRateAccrual.FixedRateAccrualBuilder getOrCreateFixedRateAccrual();
		@Override
		FixedRateAccrual.FixedRateAccrualBuilder getFixedRateAccrual();
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder getOrCreateFloatingRateAccrual();
		@Override
		LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder getFloatingRateAccrual();
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder getOrCreateLegacyFloatingRateAccrual();
		@Override
		LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder getLegacyFloatingRateAccrual();
		FxTerms.FxTermsBuilder getOrCreateFacilityFxRate();
		@Override
		FxTerms.FxTermsBuilder getFacilityFxRate();
		@Override
		LoanContract.LoanContractBuilder setId(String id);
		@Override
		LoanContract.LoanContractBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanContract.LoanContractBuilder addContractId(ContractId contractId);
		@Override
		LoanContract.LoanContractBuilder addContractId(ContractId contractId, int idx);
		@Override
		LoanContract.LoanContractBuilder addContractId(List<? extends ContractId> contractId);
		@Override
		LoanContract.LoanContractBuilder setContractId(List<? extends ContractId> contractId);
		@Override
		LoanContract.LoanContractBuilder addVersionedContractId(VersionedContractId versionedContractId);
		@Override
		LoanContract.LoanContractBuilder addVersionedContractId(VersionedContractId versionedContractId, int idx);
		@Override
		LoanContract.LoanContractBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LoanContract.LoanContractBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LoanContract.LoanContractBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		LoanContract.LoanContractBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LoanContract.LoanContractBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		LoanContract.LoanContractBuilder setGuarantorPartyReference(PartyReference guarantorPartyReference);
		@Override
		LoanContract.LoanContractBuilder setAmount(MoneyWithParticipantShare amount);
		LoanContract.LoanContractBuilder setRepricingDate(ZonedDateTime repricingDate);
		LoanContract.LoanContractBuilder setMaturityDate(ZonedDateTime maturityDate);
		LoanContract.LoanContractBuilder setFixedRateAccrual(FixedRateAccrual fixedRateAccrual);
		LoanContract.LoanContractBuilder setFloatingRateAccrual(LoanFloatingRateAccrual floatingRateAccrual);
		LoanContract.LoanContractBuilder setLegacyFloatingRateAccrual(LegacyFloatingRateAccrual legacyFloatingRateAccrual);
		LoanContract.LoanContractBuilder setFacilityFxRate(FxTerms facilityFxRate);

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
			processor.processBasic(path.newSubPath("repricingDate"), ZonedDateTime.class, getRepricingDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
			processRosetta(path.newSubPath("fixedRateAccrual"), processor, FixedRateAccrual.FixedRateAccrualBuilder.class, getFixedRateAccrual());
			processRosetta(path.newSubPath("floatingRateAccrual"), processor, LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder.class, getFloatingRateAccrual());
			processRosetta(path.newSubPath("legacyFloatingRateAccrual"), processor, LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder.class, getLegacyFloatingRateAccrual());
			processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.FxTermsBuilder.class, getFacilityFxRate());
		}
		

		LoanContract.LoanContractBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContract  ***********************/
	class LoanContractImpl extends LoanContractSummary.LoanContractSummaryImpl implements LoanContract {
		private final ZonedDateTime repricingDate;
		private final ZonedDateTime maturityDate;
		private final FixedRateAccrual fixedRateAccrual;
		private final LoanFloatingRateAccrual floatingRateAccrual;
		private final LegacyFloatingRateAccrual legacyFloatingRateAccrual;
		private final FxTerms facilityFxRate;
		
		protected LoanContractImpl(LoanContract.LoanContractBuilder builder) {
			super(builder);
			this.repricingDate = builder.getRepricingDate();
			this.maturityDate = builder.getMaturityDate();
			this.fixedRateAccrual = ofNullable(builder.getFixedRateAccrual()).map(f->f.build()).orElse(null);
			this.floatingRateAccrual = ofNullable(builder.getFloatingRateAccrual()).map(f->f.build()).orElse(null);
			this.legacyFloatingRateAccrual = ofNullable(builder.getLegacyFloatingRateAccrual()).map(f->f.build()).orElse(null);
			this.facilityFxRate = ofNullable(builder.getFacilityFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("repricingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("repricingDate")
		public ZonedDateTime getRepricingDate() {
			return repricingDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("fixedRateAccrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateAccrual")
		public FixedRateAccrual getFixedRateAccrual() {
			return fixedRateAccrual;
		}
		
		@Override
		@RosettaAttribute("floatingRateAccrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateAccrual")
		public LoanFloatingRateAccrual getFloatingRateAccrual() {
			return floatingRateAccrual;
		}
		
		@Override
		@RosettaAttribute("legacyFloatingRateAccrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyFloatingRateAccrual")
		public LegacyFloatingRateAccrual getLegacyFloatingRateAccrual() {
			return legacyFloatingRateAccrual;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityFxRate")
		public FxTerms getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public LoanContract build() {
			return this;
		}
		
		@Override
		public LoanContract.LoanContractBuilder toBuilder() {
			LoanContract.LoanContractBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContract.LoanContractBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRepricingDate()).ifPresent(builder::setRepricingDate);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
			ofNullable(getFixedRateAccrual()).ifPresent(builder::setFixedRateAccrual);
			ofNullable(getFloatingRateAccrual()).ifPresent(builder::setFloatingRateAccrual);
			ofNullable(getLegacyFloatingRateAccrual()).ifPresent(builder::setLegacyFloatingRateAccrual);
			ofNullable(getFacilityFxRate()).ifPresent(builder::setFacilityFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContract _that = getType().cast(o);
		
			if (!Objects.equals(repricingDate, _that.getRepricingDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(fixedRateAccrual, _that.getFixedRateAccrual())) return false;
			if (!Objects.equals(floatingRateAccrual, _that.getFloatingRateAccrual())) return false;
			if (!Objects.equals(legacyFloatingRateAccrual, _that.getLegacyFloatingRateAccrual())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (repricingDate != null ? repricingDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (fixedRateAccrual != null ? fixedRateAccrual.hashCode() : 0);
			_result = 31 * _result + (floatingRateAccrual != null ? floatingRateAccrual.hashCode() : 0);
			_result = 31 * _result + (legacyFloatingRateAccrual != null ? legacyFloatingRateAccrual.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContract {" +
				"repricingDate=" + this.repricingDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"fixedRateAccrual=" + this.fixedRateAccrual + ", " +
				"floatingRateAccrual=" + this.floatingRateAccrual + ", " +
				"legacyFloatingRateAccrual=" + this.legacyFloatingRateAccrual + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContract  ***********************/
	class LoanContractBuilderImpl extends LoanContractSummary.LoanContractSummaryBuilderImpl implements LoanContract.LoanContractBuilder {
	
		protected ZonedDateTime repricingDate;
		protected ZonedDateTime maturityDate;
		protected FixedRateAccrual.FixedRateAccrualBuilder fixedRateAccrual;
		protected LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder floatingRateAccrual;
		protected LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder legacyFloatingRateAccrual;
		protected FxTerms.FxTermsBuilder facilityFxRate;
		
		@Override
		@RosettaAttribute("repricingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("repricingDate")
		public ZonedDateTime getRepricingDate() {
			return repricingDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public ZonedDateTime getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("fixedRateAccrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateAccrual")
		public FixedRateAccrual.FixedRateAccrualBuilder getFixedRateAccrual() {
			return fixedRateAccrual;
		}
		
		@Override
		public FixedRateAccrual.FixedRateAccrualBuilder getOrCreateFixedRateAccrual() {
			FixedRateAccrual.FixedRateAccrualBuilder result;
			if (fixedRateAccrual!=null) {
				result = fixedRateAccrual;
			}
			else {
				result = fixedRateAccrual = FixedRateAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateAccrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateAccrual")
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder getFloatingRateAccrual() {
			return floatingRateAccrual;
		}
		
		@Override
		public LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder getOrCreateFloatingRateAccrual() {
			LoanFloatingRateAccrual.LoanFloatingRateAccrualBuilder result;
			if (floatingRateAccrual!=null) {
				result = floatingRateAccrual;
			}
			else {
				result = floatingRateAccrual = LoanFloatingRateAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyFloatingRateAccrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyFloatingRateAccrual")
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder getLegacyFloatingRateAccrual() {
			return legacyFloatingRateAccrual;
		}
		
		@Override
		public LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder getOrCreateLegacyFloatingRateAccrual() {
			LegacyFloatingRateAccrual.LegacyFloatingRateAccrualBuilder result;
			if (legacyFloatingRateAccrual!=null) {
				result = legacyFloatingRateAccrual;
			}
			else {
				result = legacyFloatingRateAccrual = LegacyFloatingRateAccrual.builder();
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
		public LoanContract.LoanContractBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanContract.LoanContractBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractId")
		@Override
		public LoanContract.LoanContractBuilder addContractId(ContractId _contractId) {
			if (_contractId != null) {
				this.contractId.add(_contractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContract.LoanContractBuilder addContractId(ContractId _contractId, int idx) {
			getIndex(this.contractId, idx, () -> _contractId.toBuilder());
			return this;
		}
		
		@Override
		public LoanContract.LoanContractBuilder addContractId(List<? extends ContractId> contractIds) {
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
		public LoanContract.LoanContractBuilder setContractId(List<? extends ContractId> contractIds) {
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
		public LoanContract.LoanContractBuilder addVersionedContractId(VersionedContractId _versionedContractId) {
			if (_versionedContractId != null) {
				this.versionedContractId.add(_versionedContractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContract.LoanContractBuilder addVersionedContractId(VersionedContractId _versionedContractId, int idx) {
			getIndex(this.versionedContractId, idx, () -> _versionedContractId.toBuilder());
			return this;
		}
		
		@Override
		public LoanContract.LoanContractBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public LoanContract.LoanContractBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public LoanContract.LoanContractBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LoanContract.LoanContractBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public LoanContract.LoanContractBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("guarantorPartyReference")
		@Override
		public LoanContract.LoanContractBuilder setGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			this.guarantorPartyReference = _guarantorPartyReference == null ? null : _guarantorPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanContract.LoanContractBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("repricingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("repricingDate")
		@Override
		public LoanContract.LoanContractBuilder setRepricingDate(ZonedDateTime _repricingDate) {
			this.repricingDate = _repricingDate == null ? null : _repricingDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public LoanContract.LoanContractBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("fixedRateAccrual")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateAccrual")
		@Override
		public LoanContract.LoanContractBuilder setFixedRateAccrual(FixedRateAccrual _fixedRateAccrual) {
			this.fixedRateAccrual = _fixedRateAccrual == null ? null : _fixedRateAccrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateAccrual")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateAccrual")
		@Override
		public LoanContract.LoanContractBuilder setFloatingRateAccrual(LoanFloatingRateAccrual _floatingRateAccrual) {
			this.floatingRateAccrual = _floatingRateAccrual == null ? null : _floatingRateAccrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyFloatingRateAccrual")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyFloatingRateAccrual")
		@Override
		public LoanContract.LoanContractBuilder setLegacyFloatingRateAccrual(LegacyFloatingRateAccrual _legacyFloatingRateAccrual) {
			this.legacyFloatingRateAccrual = _legacyFloatingRateAccrual == null ? null : _legacyFloatingRateAccrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityFxRate")
		@Override
		public LoanContract.LoanContractBuilder setFacilityFxRate(FxTerms _facilityFxRate) {
			this.facilityFxRate = _facilityFxRate == null ? null : _facilityFxRate.toBuilder();
			return this;
		}
		
		@Override
		public LoanContract build() {
			return new LoanContract.LoanContractImpl(this);
		}
		
		@Override
		public LoanContract.LoanContractBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContract.LoanContractBuilder prune() {
			super.prune();
			if (fixedRateAccrual!=null && !fixedRateAccrual.prune().hasData()) fixedRateAccrual = null;
			if (floatingRateAccrual!=null && !floatingRateAccrual.prune().hasData()) floatingRateAccrual = null;
			if (legacyFloatingRateAccrual!=null && !legacyFloatingRateAccrual.prune().hasData()) legacyFloatingRateAccrual = null;
			if (facilityFxRate!=null && !facilityFxRate.prune().hasData()) facilityFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRepricingDate()!=null) return true;
			if (getMaturityDate()!=null) return true;
			if (getFixedRateAccrual()!=null && getFixedRateAccrual().hasData()) return true;
			if (getFloatingRateAccrual()!=null && getFloatingRateAccrual().hasData()) return true;
			if (getLegacyFloatingRateAccrual()!=null && getLegacyFloatingRateAccrual().hasData()) return true;
			if (getFacilityFxRate()!=null && getFacilityFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContract.LoanContractBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanContract.LoanContractBuilder o = (LoanContract.LoanContractBuilder) other;
			
			merger.mergeRosetta(getFixedRateAccrual(), o.getFixedRateAccrual(), this::setFixedRateAccrual);
			merger.mergeRosetta(getFloatingRateAccrual(), o.getFloatingRateAccrual(), this::setFloatingRateAccrual);
			merger.mergeRosetta(getLegacyFloatingRateAccrual(), o.getLegacyFloatingRateAccrual(), this::setLegacyFloatingRateAccrual);
			merger.mergeRosetta(getFacilityFxRate(), o.getFacilityFxRate(), this::setFacilityFxRate);
			
			merger.mergeBasic(getRepricingDate(), o.getRepricingDate(), this::setRepricingDate);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContract _that = getType().cast(o);
		
			if (!Objects.equals(repricingDate, _that.getRepricingDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(fixedRateAccrual, _that.getFixedRateAccrual())) return false;
			if (!Objects.equals(floatingRateAccrual, _that.getFloatingRateAccrual())) return false;
			if (!Objects.equals(legacyFloatingRateAccrual, _that.getLegacyFloatingRateAccrual())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (repricingDate != null ? repricingDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (fixedRateAccrual != null ? fixedRateAccrual.hashCode() : 0);
			_result = 31 * _result + (floatingRateAccrual != null ? floatingRateAccrual.hashCode() : 0);
			_result = 31 * _result + (legacyFloatingRateAccrual != null ? legacyFloatingRateAccrual.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractBuilder {" +
				"repricingDate=" + this.repricingDate + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"fixedRateAccrual=" + this.fixedRateAccrual + ", " +
				"floatingRateAccrual=" + this.floatingRateAccrual + ", " +
				"legacyFloatingRateAccrual=" + this.legacyFloatingRateAccrual + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}
}
