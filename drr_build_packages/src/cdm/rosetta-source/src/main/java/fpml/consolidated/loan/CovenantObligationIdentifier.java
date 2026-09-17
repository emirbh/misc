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
import fpml.consolidated.loan.meta.CovenantObligationIdentifierMeta;
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
 * Provision A type defining a covenant obligation identifier issued by the indicated party.
 *
 */
@RosettaDataType(value="CovenantObligationIdentifier", builder=CovenantObligationIdentifier.CovenantObligationIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CovenantObligationIdentifier", model="fpml", builder=CovenantObligationIdentifier.CovenantObligationIdentifierBuilderImpl.class, version="2.1.1")
public interface CovenantObligationIdentifier extends RosettaModelObject {

	CovenantObligationIdentifierMeta metaData = new CovenantObligationIdentifierMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Long name of the underlying covenant obligation.
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that defines a covenant obligation identifier based on a qualifying scheme.
	 *
	 */
	List<? extends CovenantObligationId> getCovenantObligationId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends VersionedCovenantObligationId> getVersionedCovenantObligationId();

	/*********************** Build Methods  ***********************/
	CovenantObligationIdentifier build();
	
	CovenantObligationIdentifier.CovenantObligationIdentifierBuilder toBuilder();
	
	static CovenantObligationIdentifier.CovenantObligationIdentifierBuilder builder() {
		return new CovenantObligationIdentifier.CovenantObligationIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CovenantObligationIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CovenantObligationIdentifier> getType() {
		return CovenantObligationIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.class, getCovenantObligationId());
		processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.class, getVersionedCovenantObligationId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CovenantObligationIdentifierBuilder extends CovenantObligationIdentifier, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		CovenantObligationId.CovenantObligationIdBuilder getOrCreateCovenantObligationId(int index);
		@Override
		List<? extends CovenantObligationId.CovenantObligationIdBuilder> getCovenantObligationId();
		VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder getOrCreateVersionedCovenantObligationId(int index);
		@Override
		List<? extends VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder> getVersionedCovenantObligationId();
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setId(String id);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setName(String name);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setPartyReference(PartyReference partyReference);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addCovenantObligationId(CovenantObligationId covenantObligationId);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addCovenantObligationId(CovenantObligationId covenantObligationId, int idx);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationId);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId versionedCovenantObligationId, int idx);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);
		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("covenantObligationId"), processor, CovenantObligationId.CovenantObligationIdBuilder.class, getCovenantObligationId());
			processRosetta(path.newSubPath("versionedCovenantObligationId"), processor, VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder.class, getVersionedCovenantObligationId());
		}
		

		CovenantObligationIdentifier.CovenantObligationIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of CovenantObligationIdentifier  ***********************/
	class CovenantObligationIdentifierImpl implements CovenantObligationIdentifier {
		private final String id;
		private final String name;
		private final PartyReference partyReference;
		private final List<? extends CovenantObligationId> covenantObligationId;
		private final List<? extends VersionedCovenantObligationId> versionedCovenantObligationId;
		
		protected CovenantObligationIdentifierImpl(CovenantObligationIdentifier.CovenantObligationIdentifierBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.covenantObligationId = ofNullable(builder.getCovenantObligationId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.versionedCovenantObligationId = ofNullable(builder.getVersionedCovenantObligationId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("covenantObligationId")
		public List<? extends CovenantObligationId> getCovenantObligationId() {
			return covenantObligationId;
		}
		
		@Override
		@RosettaAttribute("versionedCovenantObligationId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("versionedCovenantObligationId")
		public List<? extends VersionedCovenantObligationId> getVersionedCovenantObligationId() {
			return versionedCovenantObligationId;
		}
		
		@Override
		public CovenantObligationIdentifier build() {
			return this;
		}
		
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder toBuilder() {
			CovenantObligationIdentifier.CovenantObligationIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CovenantObligationIdentifier.CovenantObligationIdentifierBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getCovenantObligationId()).ifPresent(builder::setCovenantObligationId);
			ofNullable(getVersionedCovenantObligationId()).ifPresent(builder::setVersionedCovenantObligationId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CovenantObligationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(covenantObligationId, _that.getCovenantObligationId())) return false;
			if (!ListEquals.listEquals(versionedCovenantObligationId, _that.getVersionedCovenantObligationId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (covenantObligationId != null ? covenantObligationId.hashCode() : 0);
			_result = 31 * _result + (versionedCovenantObligationId != null ? versionedCovenantObligationId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CovenantObligationIdentifier {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"partyReference=" + this.partyReference + ", " +
				"covenantObligationId=" + this.covenantObligationId + ", " +
				"versionedCovenantObligationId=" + this.versionedCovenantObligationId +
			'}';
		}
	}

	/*********************** Builder Implementation of CovenantObligationIdentifier  ***********************/
	class CovenantObligationIdentifierBuilderImpl implements CovenantObligationIdentifier.CovenantObligationIdentifierBuilder {
	
		protected String id;
		protected String name;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<CovenantObligationId.CovenantObligationIdBuilder> covenantObligationId = new ArrayList<>();
		protected List<VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder> versionedCovenantObligationId = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("covenantObligationId")
		public List<? extends CovenantObligationId.CovenantObligationIdBuilder> getCovenantObligationId() {
			return covenantObligationId;
		}
		
		@Override
		public CovenantObligationId.CovenantObligationIdBuilder getOrCreateCovenantObligationId(int index) {
			if (covenantObligationId==null) {
				this.covenantObligationId = new ArrayList<>();
			}
			return getIndex(covenantObligationId, index, () -> {
						CovenantObligationId.CovenantObligationIdBuilder newCovenantObligationId = CovenantObligationId.builder();
						return newCovenantObligationId;
					});
		}
		
		@Override
		@RosettaAttribute("versionedCovenantObligationId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("versionedCovenantObligationId")
		public List<? extends VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder> getVersionedCovenantObligationId() {
			return versionedCovenantObligationId;
		}
		
		@Override
		public VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder getOrCreateVersionedCovenantObligationId(int index) {
			if (versionedCovenantObligationId==null) {
				this.versionedCovenantObligationId = new ArrayList<>();
			}
			return getIndex(versionedCovenantObligationId, index, () -> {
						VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder newVersionedCovenantObligationId = VersionedCovenantObligationId.builder();
						return newVersionedCovenantObligationId;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("covenantObligationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("covenantObligationId")
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId) {
			if (_covenantObligationId != null) {
				this.covenantObligationId.add(_covenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addCovenantObligationId(CovenantObligationId _covenantObligationId, int idx) {
			getIndex(this.covenantObligationId, idx, () -> _covenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
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
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setCovenantObligationId(List<? extends CovenantObligationId> covenantObligationIds) {
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
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId) {
			if (_versionedCovenantObligationId != null) {
				this.versionedCovenantObligationId.add(_versionedCovenantObligationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addVersionedCovenantObligationId(VersionedCovenantObligationId _versionedCovenantObligationId, int idx) {
			getIndex(this.versionedCovenantObligationId, idx, () -> _versionedCovenantObligationId.toBuilder());
			return this;
		}
		
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder addVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
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
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder setVersionedCovenantObligationId(List<? extends VersionedCovenantObligationId> versionedCovenantObligationIds) {
			if (versionedCovenantObligationIds == null) {
				this.versionedCovenantObligationId = new ArrayList<>();
			} else {
				this.versionedCovenantObligationId = versionedCovenantObligationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CovenantObligationIdentifier build() {
			return new CovenantObligationIdentifier.CovenantObligationIdentifierImpl(this);
		}
		
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			covenantObligationId = covenantObligationId.stream().filter(b->b!=null).<CovenantObligationId.CovenantObligationIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			versionedCovenantObligationId = versionedCovenantObligationId.stream().filter(b->b!=null).<VersionedCovenantObligationId.VersionedCovenantObligationIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getCovenantObligationId()!=null && getCovenantObligationId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getVersionedCovenantObligationId()!=null && getVersionedCovenantObligationId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CovenantObligationIdentifier.CovenantObligationIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CovenantObligationIdentifier.CovenantObligationIdentifierBuilder o = (CovenantObligationIdentifier.CovenantObligationIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getCovenantObligationId(), o.getCovenantObligationId(), this::getOrCreateCovenantObligationId);
			merger.mergeRosetta(getVersionedCovenantObligationId(), o.getVersionedCovenantObligationId(), this::getOrCreateVersionedCovenantObligationId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CovenantObligationIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(covenantObligationId, _that.getCovenantObligationId())) return false;
			if (!ListEquals.listEquals(versionedCovenantObligationId, _that.getVersionedCovenantObligationId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (covenantObligationId != null ? covenantObligationId.hashCode() : 0);
			_result = 31 * _result + (versionedCovenantObligationId != null ? versionedCovenantObligationId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CovenantObligationIdentifierBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"partyReference=" + this.partyReference + ", " +
				"covenantObligationId=" + this.covenantObligationId + ", " +
				"versionedCovenantObligationId=" + this.versionedCovenantObligationId +
			'}';
		}
	}
}
