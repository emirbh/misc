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
import fpml.consolidated.loan.meta.CovenantObligationSummaryMeta;
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
 * Provision A covenant obligation definition.
 *
 */
@RosettaDataType(value="CovenantObligationSummary", builder=CovenantObligationSummary.CovenantObligationSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CovenantObligationSummary", model="fpml", builder=CovenantObligationSummary.CovenantObligationSummaryBuilderImpl.class, version="2.1.1")
public interface CovenantObligationSummary extends CovenantObligationIdentifier {

	CovenantObligationSummaryMeta metaData = new CovenantObligationSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The start date of the covenant effectiveness.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the party obligated by the loan covenant.
	 *
	 */
	PartyReference getObligatedParty();

	/*********************** Build Methods  ***********************/
	CovenantObligationSummary build();
	
	CovenantObligationSummary.CovenantObligationSummaryBuilder toBuilder();
	
	static CovenantObligationSummary.CovenantObligationSummaryBuilder builder() {
		return new CovenantObligationSummary.CovenantObligationSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CovenantObligationSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CovenantObligationSummary> getType() {
		return CovenantObligationSummary.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface CovenantObligationSummaryBuilder extends CovenantObligationSummary, CovenantObligationIdentifier.CovenantObligationIdentifierBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateObligatedParty();
		@Override
		PartyReference.PartyReferenceBuilder getObligatedParty();
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder setId(String id);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder setName(String name);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder addCovenantObligationId(CovenantObligationId covenantObligationId);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder addCovenantObligationId(CovenantObligationId covenantObligationId, int idx);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId, int idx);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		@Override
		CovenantObligationSummary.CovenantObligationSummaryBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		CovenantObligationSummary.CovenantObligationSummaryBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		CovenantObligationSummary.CovenantObligationSummaryBuilder setObligatedParty(PartyReference obligatedParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.CovenantObligationIdBuilder.class, getCovenantObligationId());
			processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder.class, getVersionedCovenantObligationId());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("obligatedParty"), processor, PartyReference.PartyReferenceBuilder.class, getObligatedParty());
		}
		

		CovenantObligationSummary.CovenantObligationSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of CovenantObligationSummary  ***********************/
	class CovenantObligationSummaryImpl extends CovenantObligationIdentifier.CovenantObligationIdentifierImpl implements CovenantObligationSummary {
		private final ZonedDateTime effectiveDate;
		private final PartyReference obligatedParty;
		
		protected CovenantObligationSummaryImpl(CovenantObligationSummary.CovenantObligationSummaryBuilder builder) {
			super(builder);
			this.effectiveDate = builder.getEffectiveDate();
			this.obligatedParty = ofNullable(builder.getObligatedParty()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("obligatedParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("obligatedParty")
		public PartyReference getObligatedParty() {
			return obligatedParty;
		}
		
		@Override
		public CovenantObligationSummary build() {
			return this;
		}
		
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder toBuilder() {
			CovenantObligationSummary.CovenantObligationSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CovenantObligationSummary.CovenantObligationSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getObligatedParty()).ifPresent(builder::setObligatedParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CovenantObligationSummary _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(obligatedParty, _that.getObligatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (obligatedParty != null ? obligatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CovenantObligationSummary {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"obligatedParty=" + this.obligatedParty +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CovenantObligationSummary  ***********************/
	class CovenantObligationSummaryBuilderImpl extends CovenantObligationIdentifier.CovenantObligationIdentifierBuilderImpl implements CovenantObligationSummary.CovenantObligationSummaryBuilder {
	
		protected ZonedDateTime effectiveDate;
		protected PartyReference.PartyReferenceBuilder obligatedParty;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("obligatedParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("obligatedParty")
		public PartyReference.PartyReferenceBuilder getObligatedParty() {
			return obligatedParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateObligatedParty() {
			PartyReference.PartyReferenceBuilder result;
			if (obligatedParty!=null) {
				result = obligatedParty;
			}
			else {
				result = obligatedParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("covenantObligationId")
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId) {
			if (_covenantObligationId != null) {
				this.covenantObligationId.add(_covenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId, int idx) {
			getIndex(this.covenantObligationId, idx, () -> _covenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
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
		public CovenantObligationSummary.CovenantObligationSummaryBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
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
		public CovenantObligationSummary.CovenantObligationSummaryBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId) {
			if (_versionedCovenantObligationId != null) {
				this.versionedCovenantObligationId.add(_versionedCovenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId, int idx) {
			getIndex(this.versionedCovenantObligationId, idx, () -> _versionedCovenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
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
		public CovenantObligationSummary.CovenantObligationSummaryBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
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
		public CovenantObligationSummary.CovenantObligationSummaryBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("obligatedParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("obligatedParty")
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder setObligatedParty(PartyReference _obligatedParty) {
			this.obligatedParty = _obligatedParty == null ? null : _obligatedParty.toBuilder();
			return this;
		}
		
		@Override
		public CovenantObligationSummary build() {
			return new CovenantObligationSummary.CovenantObligationSummaryImpl(this);
		}
		
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder prune() {
			super.prune();
			if (obligatedParty!=null && !obligatedParty.prune().hasData()) obligatedParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getObligatedParty()!=null && getObligatedParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CovenantObligationSummary.CovenantObligationSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CovenantObligationSummary.CovenantObligationSummaryBuilder o = (CovenantObligationSummary.CovenantObligationSummaryBuilder) other;
			
			merger.mergeRosetta(getObligatedParty(), o.getObligatedParty(), this::setObligatedParty);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CovenantObligationSummary _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(obligatedParty, _that.getObligatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (obligatedParty != null ? obligatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CovenantObligationSummaryBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"obligatedParty=" + this.obligatedParty +
			'}' + " " + super.toString();
		}
	}
}
