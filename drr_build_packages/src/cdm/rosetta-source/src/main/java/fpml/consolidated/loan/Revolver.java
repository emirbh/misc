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
import fpml.consolidated.asset.Lien;
import fpml.consolidated.loan.meta.RevolverMeta;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A facility which allows a flexible line of credit which can be drawn and repaid multiple times over the life of the facility.
 *
 */
@RosettaDataType(value="Revolver", builder=Revolver.RevolverBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Revolver", model="fpml", builder=Revolver.RevolverBuilderImpl.class, version="2.1.1")
public interface Revolver extends AbstractFacility {

	RevolverMeta metaData = new RevolverMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Revolver build();
	
	Revolver.RevolverBuilder toBuilder();
	
	static Revolver.RevolverBuilder builder() {
		return new Revolver.RevolverBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Revolver> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Revolver> getType() {
		return Revolver.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("coBorrowerPartyReference"), processor, PartyReference.class, getCoBorrowerPartyReference());
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("lcIssuingBankPartyReference"), processor, PartyReference.class, getLcIssuingBankPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
		processRosetta(path.newSubPath("currentCommitment"), processor, FacilityCommitment.class, getCurrentCommitment());
		processRosetta(path.newSubPath("originalCommitment"), processor, MoneyWithParticipantShare.class, getOriginalCommitment());
		processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.class, getCommitmentSchedule());
		processRosetta(path.newSubPath("dealFxRate"), processor, FxTerms.class, getDealFxRate());
		processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.class, getGoverningLaw());
		processRosetta(path.newSubPath("feature"), processor, FacilityFeature.class, getFeature());
		processRosetta(path.newSubPath("lien"), processor, Lien.class, getLien());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processRosetta(path.newSubPath("abstractFacilityChoice"), processor, AbstractFacilityChoice.class, getAbstractFacilityChoice());
		processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.class, getAccruingPikOption());
		processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.class, getAccruingFeeOption());
		processRosetta(path.newSubPath("defaultRate"), processor, PeriodRate.class, getDefaultRate());
		processRosetta(path.newSubPath("mandatoryCostRate"), processor, PeriodRate.class, getMandatoryCostRate());
		processRosetta(path.newSubPath("penaltyRate"), processor, PeriodRate.class, getPenaltyRate());
		processRosetta(path.newSubPath("multiCurrency"), processor, MultiCurrency.class, getMultiCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RevolverBuilder extends Revolver, AbstractFacility.AbstractFacilityBuilder {
		@Override
		Revolver.RevolverBuilder setId(String id);
		@Override
		Revolver.RevolverBuilder setPartyReference(PartyReference partyReference);
		@Override
		Revolver.RevolverBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Revolver.RevolverBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Revolver.RevolverBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Revolver.RevolverBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Revolver.RevolverBuilder setDescription(String description);
		@Override
		Revolver.RevolverBuilder setDealReference(DealReference dealReference);
		@Override
		Revolver.RevolverBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		@Override
		Revolver.RevolverBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference);
		@Override
		Revolver.RevolverBuilder addCoBorrowerPartyReference(PartyReference coBorrowerPartyReference, int idx);
		@Override
		Revolver.RevolverBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		Revolver.RevolverBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReference);
		@Override
		Revolver.RevolverBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		Revolver.RevolverBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference);
		@Override
		Revolver.RevolverBuilder addLcIssuingBankPartyReference(PartyReference lcIssuingBankPartyReference, int idx);
		@Override
		Revolver.RevolverBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		Revolver.RevolverBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReference);
		@Override
		Revolver.RevolverBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference);
		@Override
		Revolver.RevolverBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int idx);
		@Override
		Revolver.RevolverBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		Revolver.RevolverBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		Revolver.RevolverBuilder setStartDate(ZonedDateTime startDate);
		@Override
		Revolver.RevolverBuilder setExpiryDate(ZonedDateTime expiryDate);
		@Override
		Revolver.RevolverBuilder setMaturityDate(ZonedDateTime maturityDate);
		@Override
		Revolver.RevolverBuilder setCurrentCommitment(FacilityCommitment currentCommitment);
		@Override
		Revolver.RevolverBuilder setOriginalCommitment(MoneyWithParticipantShare originalCommitment);
		@Override
		Revolver.RevolverBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);
		@Override
		Revolver.RevolverBuilder setDealFxRate(FxTerms dealFxRate);
		@Override
		Revolver.RevolverBuilder setGoverningLaw(GoverningLaw governingLaw);
		@Override
		Revolver.RevolverBuilder addFeature(FacilityFeature feature);
		@Override
		Revolver.RevolverBuilder addFeature(FacilityFeature feature, int idx);
		@Override
		Revolver.RevolverBuilder addFeature(List<? extends FacilityFeature> feature);
		@Override
		Revolver.RevolverBuilder setFeature(List<? extends FacilityFeature> feature);
		@Override
		Revolver.RevolverBuilder setLien(Lien lien);
		@Override
		Revolver.RevolverBuilder setSeniority(CreditSeniority seniority);
		@Override
		Revolver.RevolverBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice);
		@Override
		Revolver.RevolverBuilder addAbstractFacilityChoice(AbstractFacilityChoice abstractFacilityChoice, int idx);
		@Override
		Revolver.RevolverBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		@Override
		Revolver.RevolverBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoice);
		@Override
		Revolver.RevolverBuilder setAccruingPikOption(AccruingPikOption accruingPikOption);
		@Override
		Revolver.RevolverBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption);
		@Override
		Revolver.RevolverBuilder addAccruingFeeOption(AccruingFeeOption accruingFeeOption, int idx);
		@Override
		Revolver.RevolverBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		@Override
		Revolver.RevolverBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOption);
		@Override
		Revolver.RevolverBuilder setDefaultRate(PeriodRate defaultRate);
		@Override
		Revolver.RevolverBuilder setMandatoryCostRate(PeriodRate mandatoryCostRate);
		@Override
		Revolver.RevolverBuilder setPenaltyRate(PeriodRate penaltyRate);
		@Override
		Revolver.RevolverBuilder setMultiCurrency(MultiCurrency multiCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("coBorrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCoBorrowerPartyReference());
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("lcIssuingBankPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLcIssuingBankPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), ZonedDateTime.class, getMaturityDate(), this);
			processRosetta(path.newSubPath("currentCommitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getCurrentCommitment());
			processRosetta(path.newSubPath("originalCommitment"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getOriginalCommitment());
			processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.CommitmentScheduleBuilder.class, getCommitmentSchedule());
			processRosetta(path.newSubPath("dealFxRate"), processor, FxTerms.FxTermsBuilder.class, getDealFxRate());
			processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.GoverningLawBuilder.class, getGoverningLaw());
			processRosetta(path.newSubPath("feature"), processor, FacilityFeature.FacilityFeatureBuilder.class, getFeature());
			processRosetta(path.newSubPath("lien"), processor, Lien.LienBuilder.class, getLien());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processRosetta(path.newSubPath("abstractFacilityChoice"), processor, AbstractFacilityChoice.AbstractFacilityChoiceBuilder.class, getAbstractFacilityChoice());
			processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.AccruingPikOptionBuilder.class, getAccruingPikOption());
			processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.AccruingFeeOptionBuilder.class, getAccruingFeeOption());
			processRosetta(path.newSubPath("defaultRate"), processor, PeriodRate.PeriodRateBuilder.class, getDefaultRate());
			processRosetta(path.newSubPath("mandatoryCostRate"), processor, PeriodRate.PeriodRateBuilder.class, getMandatoryCostRate());
			processRosetta(path.newSubPath("penaltyRate"), processor, PeriodRate.PeriodRateBuilder.class, getPenaltyRate());
			processRosetta(path.newSubPath("multiCurrency"), processor, MultiCurrency.MultiCurrencyBuilder.class, getMultiCurrency());
		}
		

		Revolver.RevolverBuilder prune();
	}

	/*********************** Immutable Implementation of Revolver  ***********************/
	class RevolverImpl extends AbstractFacility.AbstractFacilityImpl implements Revolver {
		
		protected RevolverImpl(Revolver.RevolverBuilder builder) {
			super(builder);
		}
		
		@Override
		public Revolver build() {
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder toBuilder() {
			Revolver.RevolverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Revolver.RevolverBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Revolver {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Revolver  ***********************/
	class RevolverBuilderImpl extends AbstractFacility.AbstractFacilityBuilderImpl implements Revolver.RevolverBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Revolver.RevolverBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public Revolver.RevolverBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Revolver.RevolverBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Revolver.RevolverBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public Revolver.RevolverBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public Revolver.RevolverBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public Revolver.RevolverBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public Revolver.RevolverBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference) {
			if (_coBorrowerPartyReference != null) {
				this.coBorrowerPartyReference.add(_coBorrowerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addCoBorrowerPartyReference(PartyReference _coBorrowerPartyReference, int idx) {
			getIndex(this.coBorrowerPartyReference, idx, () -> _coBorrowerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
			if (coBorrowerPartyReferences != null) {
				for (final PartyReference toAdd : coBorrowerPartyReferences) {
					this.coBorrowerPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("coBorrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("coBorrowerPartyReference")
		@Override
		public Revolver.RevolverBuilder setCoBorrowerPartyReference(List<? extends PartyReference> coBorrowerPartyReferences) {
			if (coBorrowerPartyReferences == null) {
				this.coBorrowerPartyReference = new ArrayList<>();
			} else {
				this.coBorrowerPartyReference = coBorrowerPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agentPartyReference")
		@Override
		public Revolver.RevolverBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public Revolver.RevolverBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference) {
			if (_lcIssuingBankPartyReference != null) {
				this.lcIssuingBankPartyReference.add(_lcIssuingBankPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addLcIssuingBankPartyReference(PartyReference _lcIssuingBankPartyReference, int idx) {
			getIndex(this.lcIssuingBankPartyReference, idx, () -> _lcIssuingBankPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
			if (lcIssuingBankPartyReferences != null) {
				for (final PartyReference toAdd : lcIssuingBankPartyReferences) {
					this.lcIssuingBankPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("lcIssuingBankPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("lcIssuingBankPartyReference")
		@Override
		public Revolver.RevolverBuilder setLcIssuingBankPartyReference(List<? extends PartyReference> lcIssuingBankPartyReferences) {
			if (lcIssuingBankPartyReferences == null) {
				this.lcIssuingBankPartyReference = new ArrayList<>();
			} else {
				this.lcIssuingBankPartyReference = lcIssuingBankPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public Revolver.RevolverBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			if (_guarantorPartyReference != null) {
				this.guarantorPartyReference.add(_guarantorPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference, int idx) {
			getIndex(this.guarantorPartyReference, idx, () -> _guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences != null) {
				for (final PartyReference toAdd : guarantorPartyReferences) {
					this.guarantorPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public Revolver.RevolverBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences == null) {
				this.guarantorPartyReference = new ArrayList<>();
			} else {
				this.guarantorPartyReference = guarantorPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public Revolver.RevolverBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public Revolver.RevolverBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public Revolver.RevolverBuilder setMaturityDate(ZonedDateTime _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("currentCommitment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currentCommitment")
		@Override
		public Revolver.RevolverBuilder setCurrentCommitment(FacilityCommitment _currentCommitment) {
			this.currentCommitment = _currentCommitment == null ? null : _currentCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalCommitment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalCommitment")
		@Override
		public Revolver.RevolverBuilder setOriginalCommitment(MoneyWithParticipantShare _originalCommitment) {
			this.originalCommitment = _originalCommitment == null ? null : _originalCommitment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commitmentSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commitmentSchedule")
		@Override
		public Revolver.RevolverBuilder setCommitmentSchedule(CommitmentSchedule _commitmentSchedule) {
			this.commitmentSchedule = _commitmentSchedule == null ? null : _commitmentSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealFxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealFxRate")
		@Override
		public Revolver.RevolverBuilder setDealFxRate(FxTerms _dealFxRate) {
			this.dealFxRate = _dealFxRate == null ? null : _dealFxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("governingLaw")
		@Override
		public Revolver.RevolverBuilder setGoverningLaw(GoverningLaw _governingLaw) {
			this.governingLaw = _governingLaw == null ? null : _governingLaw.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public Revolver.RevolverBuilder addFeature(FacilityFeature _feature) {
			if (_feature != null) {
				this.feature.add(_feature.toBuilder());
			}
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addFeature(FacilityFeature _feature, int idx) {
			getIndex(this.feature, idx, () -> _feature.toBuilder());
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addFeature(List<? extends FacilityFeature> features) {
			if (features != null) {
				for (final FacilityFeature toAdd : features) {
					this.feature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public Revolver.RevolverBuilder setFeature(List<? extends FacilityFeature> features) {
			if (features == null) {
				this.feature = new ArrayList<>();
			} else {
				this.feature = features.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("lien")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lien")
		@Override
		public Revolver.RevolverBuilder setLien(Lien _lien) {
			this.lien = _lien == null ? null : _lien.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public Revolver.RevolverBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		@Override
		public Revolver.RevolverBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice) {
			if (_abstractFacilityChoice != null) {
				this.abstractFacilityChoice.add(_abstractFacilityChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addAbstractFacilityChoice(AbstractFacilityChoice _abstractFacilityChoice, int idx) {
			getIndex(this.abstractFacilityChoice, idx, () -> _abstractFacilityChoice.toBuilder());
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
			if (abstractFacilityChoices != null) {
				for (final AbstractFacilityChoice toAdd : abstractFacilityChoices) {
					this.abstractFacilityChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("abstractFacilityChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("abstractFacilityChoice")
		@Override
		public Revolver.RevolverBuilder setAbstractFacilityChoice(List<? extends AbstractFacilityChoice> abstractFacilityChoices) {
			if (abstractFacilityChoices == null) {
				this.abstractFacilityChoice = new ArrayList<>();
			} else {
				this.abstractFacilityChoice = abstractFacilityChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("accruingPikOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruingPikOption")
		@Override
		public Revolver.RevolverBuilder setAccruingPikOption(AccruingPikOption _accruingPikOption) {
			this.accruingPikOption = _accruingPikOption == null ? null : _accruingPikOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		@Override
		public Revolver.RevolverBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption) {
			if (_accruingFeeOption != null) {
				this.accruingFeeOption.add(_accruingFeeOption.toBuilder());
			}
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addAccruingFeeOption(AccruingFeeOption _accruingFeeOption, int idx) {
			getIndex(this.accruingFeeOption, idx, () -> _accruingFeeOption.toBuilder());
			return this;
		}
		
		@Override
		public Revolver.RevolverBuilder addAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
			if (accruingFeeOptions != null) {
				for (final AccruingFeeOption toAdd : accruingFeeOptions) {
					this.accruingFeeOption.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accruingFeeOption")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accruingFeeOption")
		@Override
		public Revolver.RevolverBuilder setAccruingFeeOption(List<? extends AccruingFeeOption> accruingFeeOptions) {
			if (accruingFeeOptions == null) {
				this.accruingFeeOption = new ArrayList<>();
			} else {
				this.accruingFeeOption = accruingFeeOptions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("defaultRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("defaultRate")
		@Override
		public Revolver.RevolverBuilder setDefaultRate(PeriodRate _defaultRate) {
			this.defaultRate = _defaultRate == null ? null : _defaultRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatoryCostRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryCostRate")
		@Override
		public Revolver.RevolverBuilder setMandatoryCostRate(PeriodRate _mandatoryCostRate) {
			this.mandatoryCostRate = _mandatoryCostRate == null ? null : _mandatoryCostRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("penaltyRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("penaltyRate")
		@Override
		public Revolver.RevolverBuilder setPenaltyRate(PeriodRate _penaltyRate) {
			this.penaltyRate = _penaltyRate == null ? null : _penaltyRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiCurrency")
		@Override
		public Revolver.RevolverBuilder setMultiCurrency(MultiCurrency _multiCurrency) {
			this.multiCurrency = _multiCurrency == null ? null : _multiCurrency.toBuilder();
			return this;
		}
		
		@Override
		public Revolver build() {
			return new Revolver.RevolverImpl(this);
		}
		
		@Override
		public Revolver.RevolverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Revolver.RevolverBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Revolver.RevolverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Revolver.RevolverBuilder o = (Revolver.RevolverBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RevolverBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
