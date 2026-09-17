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
import fpml.consolidated.loan.meta.LoanCovenantObligationSummaryMeta;
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
 * Provision A syndicated bank loan deal (credit agreement) covenant obligation summary.
 *
 */
@RosettaDataType(value="LoanCovenantObligationSummary", builder=LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationSummary", model="fpml", builder=LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationSummary extends CovenantObligationSummary {

	LoanCovenantObligationSummaryMeta metaData = new LoanCovenantObligationSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	DealReference getDealReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends FacilityReference> getFacilityReference();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationSummary build();
	
	LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder toBuilder();
	
	static LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder builder() {
		return new LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationSummary> getType() {
		return LoanCovenantObligationSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.class, getCovenantObligationId());
		processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.class, getVersionedCovenantObligationId());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("obligatedParty"), processor, PartyReference.class, getObligatedParty());
		processRosetta(path.newSubPath("dealReference"), processor, DealReference.class, getDealReference());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationSummaryBuilder extends LoanCovenantObligationSummary, CovenantObligationSummary.CovenantObligationSummaryBuilder {
		DealReference.DealReferenceBuilder getOrCreateDealReference();
		@Override
		DealReference.DealReferenceBuilder getDealReference();
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference(int index);
		@Override
		List<? extends FacilityReference.FacilityReferenceBuilder> getFacilityReference();
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setId(String id);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setName(String name);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addCovenantObligationId(CovenantObligationId covenantObligationId);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addCovenantObligationId(CovenantObligationId covenantObligationId, int idx);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId, int idx);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setObligatedParty(PartyReference obligatedParty);
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setDealReference(DealReference dealReference);
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addFacilityReference(FacilityReference facilityReference);
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.CovenantObligationIdBuilder.class, getCovenantObligationId());
			processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder.class, getVersionedCovenantObligationId());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("obligatedParty"), processor, PartyReference.PartyReferenceBuilder.class, getObligatedParty());
			processRosetta(path.newSubPath("dealReference"), processor, DealReference.DealReferenceBuilder.class, getDealReference());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationSummary  ***********************/
	class LoanCovenantObligationSummaryImpl extends CovenantObligationSummary.CovenantObligationSummaryImpl implements LoanCovenantObligationSummary {
		private final DealReference dealReference;
		private final List<? extends FacilityReference> facilityReference;
		
		protected LoanCovenantObligationSummaryImpl(LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder builder) {
			super(builder);
			this.dealReference = ofNullable(builder.getDealReference()).map(f->f.build()).orElse(null);
			this.facilityReference = ofNullable(builder.getFacilityReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public LoanCovenantObligationSummary build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder toBuilder() {
			LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDealReference()).ifPresent(builder::setDealReference);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligationSummary _that = getType().cast(o);
		
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationSummary {" +
				"dealReference=" + this.dealReference + ", " +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationSummary  ***********************/
	class LoanCovenantObligationSummaryBuilderImpl extends CovenantObligationSummary.CovenantObligationSummaryBuilderImpl implements LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder {
	
		protected DealReference.DealReferenceBuilder dealReference;
		protected List<FacilityReference.FacilityReferenceBuilder> facilityReference = new ArrayList<>();
		
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
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("covenantObligationId")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId) {
			if (_covenantObligationId != null) {
				this.covenantObligationId.add(_covenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId, int idx) {
			getIndex(this.covenantObligationId, idx, () -> _covenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
			if (covenantObligationIds != null) {
				for (final CovenantObligationId toAdd : covenantObligationIds) {
					this.covenantObligationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("covenantObligationId")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
			if (covenantObligationIds == null) {
				this.covenantObligationId = new ArrayList<>();
			} else {
				this.covenantObligationId = covenantObligationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("versionedCovenantObligationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("versionedCovenantObligationId")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId) {
			if (_versionedCovenantObligationId != null) {
				this.versionedCovenantObligationId.add(_versionedCovenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId, int idx) {
			getIndex(this.versionedCovenantObligationId, idx, () -> _versionedCovenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
			if (versionedCovenantObligationIds != null) {
				for (final VersionedCovenantObligationId toAdd : versionedCovenantObligationIds) {
					this.versionedCovenantObligationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("versionedCovenantObligationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("versionedCovenantObligationId")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
			if (versionedCovenantObligationIds == null) {
				this.versionedCovenantObligationId = new ArrayList<>();
			} else {
				this.versionedCovenantObligationId = versionedCovenantObligationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("obligatedParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("obligatedParty")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setObligatedParty(PartyReference _obligatedParty) {
			this.obligatedParty = _obligatedParty == null ? null : _obligatedParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealReference")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setDealReference(DealReference _dealReference) {
			this.dealReference = _dealReference == null ? null : _dealReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
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
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
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
		public LoanCovenantObligationSummary build() {
			return new LoanCovenantObligationSummary.LoanCovenantObligationSummaryImpl(this);
		}
		
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder prune() {
			super.prune();
			if (dealReference!=null && !dealReference.prune().hasData()) dealReference = null;
			facilityReference = facilityReference.stream().filter(b->b!=null).<FacilityReference.FacilityReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDealReference()!=null && getDealReference().hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder o = (LoanCovenantObligationSummary.LoanCovenantObligationSummaryBuilder) other;
			
			merger.mergeRosetta(getDealReference(), o.getDealReference(), this::setDealReference);
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::getOrCreateFacilityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanCovenantObligationSummary _that = getType().cast(o);
		
			if (!Objects.equals(dealReference, _that.getDealReference())) return false;
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dealReference != null ? dealReference.hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationSummaryBuilder {" +
				"dealReference=" + this.dealReference + ", " +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}
}
