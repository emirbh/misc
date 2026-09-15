package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.loan.meta.LoanLegalActionSummaryMeta;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A syndicated bank loan legal action definition summary.
 *
 */
@RosettaDataType(value="LoanLegalActionSummary", builder=LoanLegalActionSummary.LoanLegalActionSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionSummary", model="fpml", builder=LoanLegalActionSummary.LoanLegalActionSummaryBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionSummary extends LegalActionIdentifier {

	LoanLegalActionSummaryMeta metaData = new LoanLegalActionSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Structure to describe the details of the legal action.
	 *
	 */
	LoanLegalActionDetails getActionDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the deal impacted by the legal action.
	 *
	 */
	DealReference getDealReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the facility or facilities impacted by the legal action.
	 *
	 */
	List<? extends FacilityReference> getFacilityReference();

	/*********************** Build Methods  ***********************/
	LoanLegalActionSummary build();
	
	LoanLegalActionSummary.LoanLegalActionSummaryBuilder toBuilder();
	
	static LoanLegalActionSummary.LoanLegalActionSummaryBuilder builder() {
		return new LoanLegalActionSummary.LoanLegalActionSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionSummary> getType() {
		return LoanLegalActionSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("legalActionId"), processor, LegalActionId.class, getLegalActionId());
		processRosetta(path.newSubPath("versionedLegalActionId"), processor, VersionedLegalActionId.class, getVersionedLegalActionId());
		processRosetta(path.newSubPath("actionDetails"), processor, LoanLegalActionDetails.class, getActionDetails());
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionSummaryBuilder extends LoanLegalActionSummary, LegalActionIdentifier.LegalActionIdentifierBuilder {
		LoanLegalActionDetails.LoanLegalActionDetailsBuilder getOrCreateActionDetails();
		@Override
		LoanLegalActionDetails.LoanLegalActionDetailsBuilder getActionDetails();
		DealReference.DealReferenceBuilder getOrCreateDealReference();
		@Override
		DealReference.DealReferenceBuilder getDealReference();
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference(int index);
		@Override
		List<? extends FacilityReference.FacilityReferenceBuilder> getFacilityReference();
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder setId(String id);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder setName(String name);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addLegalActionId(LegalActionId legalActionId);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addLegalActionId(LegalActionId legalActionId, int idx);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addLegalActionId(List<? extends LegalActionId> legalActionId);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder setLegalActionId(List<? extends LegalActionId> legalActionId);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addVersionedLegalActionId(VersionedLegalActionId versionedLegalActionId);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addVersionedLegalActionId(VersionedLegalActionId versionedLegalActionId, int idx);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionId);
		@Override
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder setVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionId);
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder setActionDetails(LoanLegalActionDetails actionDetails);
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder setDealReference(DealReference dealReference);
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addFacilityReference(FacilityReference facilityReference);
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		LoanLegalActionSummary.LoanLegalActionSummaryBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("legalActionId"), processor, LegalActionId.LegalActionIdBuilder.class, getLegalActionId());
			processRosetta(path.newSubPath("versionedLegalActionId"), processor, VersionedLegalActionId.VersionedLegalActionIdBuilder.class, getVersionedLegalActionId());
			processRosetta(path.newSubPath("actionDetails"), processor, LoanLegalActionDetails.LoanLegalActionDetailsBuilder.class, getActionDetails());
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		LoanLegalActionSummary.LoanLegalActionSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionSummary  ***********************/
	class LoanLegalActionSummaryImpl extends LegalActionIdentifier.LegalActionIdentifierImpl implements LoanLegalActionSummary {
		private final LoanLegalActionDetails actionDetails;
		private final DealReference dealReference;
		private final List<? extends FacilityReference> facilityReference;
		
		protected LoanLegalActionSummaryImpl(LoanLegalActionSummary.LoanLegalActionSummaryBuilder builder) {
			super(builder);
			this.actionDetails = ofNullable(builder.getActionDetails()).map(f->f.build()).orElse(null);
			this.dealReference = ofNullable(builder.getDealReference()).map(f->f.build()).orElse(null);
			this.facilityReference = ofNullable(builder.getFacilityReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("actionDetails")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("actionDetails")
		public LoanLegalActionDetails getActionDetails() {
			return actionDetails;
		}
		
		@Override
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealReference")
		public DealReference getDealReference() {
			return dealReference;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityReference")
		public List<? extends FacilityReference> getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public LoanLegalActionSummary build() {
			return this;
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder toBuilder() {
			LoanLegalActionSummary.LoanLegalActionSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionSummary.LoanLegalActionSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getActionDetails()).ifPresent(builder::setActionDetails);
			ofNullable(getDealReference()).ifPresent(builder::setDealReference);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionSummary _that = getType().cast(o);
		
			if (!Objects.equals(actionDetails, _that.getActionDetails())) return false;
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (actionDetails != null ? actionDetails.hashCode() : 0);
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionSummary {" +
				"actionDetails=" + this.actionDetails + ", " +
				"dealReference=" + this.dealReference + ", " +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanLegalActionSummary  ***********************/
	class LoanLegalActionSummaryBuilderImpl extends LegalActionIdentifier.LegalActionIdentifierBuilderImpl implements LoanLegalActionSummary.LoanLegalActionSummaryBuilder {
	
		protected LoanLegalActionDetails.LoanLegalActionDetailsBuilder actionDetails;
		protected DealReference.DealReferenceBuilder dealReference;
		protected List<FacilityReference.FacilityReferenceBuilder> facilityReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("actionDetails")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("actionDetails")
		public LoanLegalActionDetails.LoanLegalActionDetailsBuilder getActionDetails() {
			return actionDetails;
		}
		
		@Override
		public LoanLegalActionDetails.LoanLegalActionDetailsBuilder getOrCreateActionDetails() {
			LoanLegalActionDetails.LoanLegalActionDetailsBuilder result;
			if (actionDetails!=null) {
				result = actionDetails;
			}
			else {
				result = actionDetails = LoanLegalActionDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealReference")
		public DealReference.DealReferenceBuilder getDealReference() {
			return dealReference;
		}
		
		@Override
		public DealReference.DealReferenceBuilder getOrCreateDealReference() {
			DealReference.DealReferenceBuilder result;
			if (dealReference!=null) {
				result = dealReference;
			}
			else {
				result = dealReference = DealReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityReference")
		public List<? extends FacilityReference.FacilityReferenceBuilder> getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference(int index) {
			if (facilityReference==null) {
				this.facilityReference = new ArrayList<>();
			}
			return getIndex(facilityReference, index, () -> {
						FacilityReference.FacilityReferenceBuilder newFacilityReference = FacilityReference.builder();
						return newFacilityReference;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legalActionId")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addLegalActionId(LegalActionId _legalActionId) {
			if (_legalActionId != null) {
				this.legalActionId.add(_legalActionId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addLegalActionId(LegalActionId _legalActionId, int idx) {
			getIndex(this.legalActionId, idx, () -> _legalActionId.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addLegalActionId(List<? extends LegalActionId> legalActionIds) {
			if (legalActionIds != null) {
				for (final LegalActionId toAdd : legalActionIds) {
					this.legalActionId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("legalActionId")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder setLegalActionId(List<? extends LegalActionId> legalActionIds) {
			if (legalActionIds == null) {
				this.legalActionId = new ArrayList<>();
			} else {
				this.legalActionId = legalActionIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("versionedLegalActionId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("versionedLegalActionId")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addVersionedLegalActionId(VersionedLegalActionId _versionedLegalActionId) {
			if (_versionedLegalActionId != null) {
				this.versionedLegalActionId.add(_versionedLegalActionId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addVersionedLegalActionId(VersionedLegalActionId _versionedLegalActionId, int idx) {
			getIndex(this.versionedLegalActionId, idx, () -> _versionedLegalActionId.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionIds) {
			if (versionedLegalActionIds != null) {
				for (final VersionedLegalActionId toAdd : versionedLegalActionIds) {
					this.versionedLegalActionId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("versionedLegalActionId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("versionedLegalActionId")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder setVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionIds) {
			if (versionedLegalActionIds == null) {
				this.versionedLegalActionId = new ArrayList<>();
			} else {
				this.versionedLegalActionId = versionedLegalActionIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("actionDetails")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("actionDetails")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder setActionDetails(LoanLegalActionDetails _actionDetails) {
			this.actionDetails = _actionDetails == null ? null : _actionDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences != null) {
				for (final FacilityReference toAdd : facilityReferences) {
					this.facilityReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences == null) {
				this.facilityReference = new ArrayList<>();
			} else {
				this.facilityReference = facilityReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanLegalActionSummary build() {
			return new LoanLegalActionSummary.LoanLegalActionSummaryImpl(this);
		}
		
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder prune() {
			super.prune();
			if (actionDetails!=null && !actionDetails.prune().hasData()) actionDetails = null;
			if (dealReference!=null && !dealReference.prune().hasData()) dealReference = null;
			facilityReference = facilityReference.stream().filter(b->b!=null).<FacilityReference.FacilityReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getActionDetails()!=null && getActionDetails().hasData()) return true;
			if (getDealReference()!=null && getDealReference().hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionSummary.LoanLegalActionSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanLegalActionSummary.LoanLegalActionSummaryBuilder o = (LoanLegalActionSummary.LoanLegalActionSummaryBuilder) other;
			
			merger.mergeRosetta(getActionDetails(), o.getActionDetails(), this::setActionDetails);
			merger.mergeRosetta(getDealReference(), o.getDealReference(), this::setDealReference);
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::getOrCreateFacilityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanLegalActionSummary _that = getType().cast(o);
		
			if (!Objects.equals(actionDetails, _that.getActionDetails())) return false;
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (actionDetails != null ? actionDetails.hashCode() : 0);
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionSummaryBuilder {" +
				"actionDetails=" + this.actionDetails + ", " +
				"dealReference=" + this.dealReference + ", " +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}
}
