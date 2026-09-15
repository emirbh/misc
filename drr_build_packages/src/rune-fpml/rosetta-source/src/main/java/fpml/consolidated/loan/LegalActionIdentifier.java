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
import fpml.consolidated.loan.meta.LegalActionIdentifierMeta;
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
 * Provision A structure to define a legal action identifier.
 *
 */
@RosettaDataType(value="LegalActionIdentifier", builder=LegalActionIdentifier.LegalActionIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegalActionIdentifier", model="fpml", builder=LegalActionIdentifier.LegalActionIdentifierBuilderImpl.class, version="2.1.1")
public interface LegalActionIdentifier extends RosettaModelObject {

	LegalActionIdentifierMeta metaData = new LegalActionIdentifierMeta();

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
	 * Provision Long name of the underlying legal action.
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
	 * Provision Identification of the legal action.
	 *
	 */
	List<? extends LegalActionId> getLegalActionId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends VersionedLegalActionId> getVersionedLegalActionId();

	/*********************** Build Methods  ***********************/
	LegalActionIdentifier build();
	
	LegalActionIdentifier.LegalActionIdentifierBuilder toBuilder();
	
	static LegalActionIdentifier.LegalActionIdentifierBuilder builder() {
		return new LegalActionIdentifier.LegalActionIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegalActionIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegalActionIdentifier> getType() {
		return LegalActionIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("legalActionId"), processor, LegalActionId.class, getLegalActionId());
		processRosetta(path.newSubPath("versionedLegalActionId"), processor, VersionedLegalActionId.class, getVersionedLegalActionId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegalActionIdentifierBuilder extends LegalActionIdentifier, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		LegalActionId.LegalActionIdBuilder getOrCreateLegalActionId(int index);
		@Override
		List<? extends LegalActionId.LegalActionIdBuilder> getLegalActionId();
		VersionedLegalActionId.VersionedLegalActionIdBuilder getOrCreateVersionedLegalActionId(int index);
		@Override
		List<? extends VersionedLegalActionId.VersionedLegalActionIdBuilder> getVersionedLegalActionId();
		LegalActionIdentifier.LegalActionIdentifierBuilder setId(String id);
		LegalActionIdentifier.LegalActionIdentifierBuilder setName(String name);
		LegalActionIdentifier.LegalActionIdentifierBuilder setPartyReference(PartyReference partyReference);
		LegalActionIdentifier.LegalActionIdentifierBuilder addLegalActionId(LegalActionId legalActionId);
		LegalActionIdentifier.LegalActionIdentifierBuilder addLegalActionId(LegalActionId legalActionId, int idx);
		LegalActionIdentifier.LegalActionIdentifierBuilder addLegalActionId(List<? extends LegalActionId> legalActionId);
		LegalActionIdentifier.LegalActionIdentifierBuilder setLegalActionId(List<? extends LegalActionId> legalActionId);
		LegalActionIdentifier.LegalActionIdentifierBuilder addVersionedLegalActionId(VersionedLegalActionId versionedLegalActionId);
		LegalActionIdentifier.LegalActionIdentifierBuilder addVersionedLegalActionId(VersionedLegalActionId versionedLegalActionId, int idx);
		LegalActionIdentifier.LegalActionIdentifierBuilder addVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionId);
		LegalActionIdentifier.LegalActionIdentifierBuilder setVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("legalActionId"), processor, LegalActionId.LegalActionIdBuilder.class, getLegalActionId());
			processRosetta(path.newSubPath("versionedLegalActionId"), processor, VersionedLegalActionId.VersionedLegalActionIdBuilder.class, getVersionedLegalActionId());
		}
		

		LegalActionIdentifier.LegalActionIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of LegalActionIdentifier  ***********************/
	class LegalActionIdentifierImpl implements LegalActionIdentifier {
		private final String id;
		private final String name;
		private final PartyReference partyReference;
		private final List<? extends LegalActionId> legalActionId;
		private final List<? extends VersionedLegalActionId> versionedLegalActionId;
		
		protected LegalActionIdentifierImpl(LegalActionIdentifier.LegalActionIdentifierBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.legalActionId = ofNullable(builder.getLegalActionId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.versionedLegalActionId = ofNullable(builder.getVersionedLegalActionId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legalActionId")
		public List<? extends LegalActionId> getLegalActionId() {
			return legalActionId;
		}
		
		@Override
		@RosettaAttribute("versionedLegalActionId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("versionedLegalActionId")
		public List<? extends VersionedLegalActionId> getVersionedLegalActionId() {
			return versionedLegalActionId;
		}
		
		@Override
		public LegalActionIdentifier build() {
			return this;
		}
		
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder toBuilder() {
			LegalActionIdentifier.LegalActionIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalActionIdentifier.LegalActionIdentifierBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getLegalActionId()).ifPresent(builder::setLegalActionId);
			ofNullable(getVersionedLegalActionId()).ifPresent(builder::setVersionedLegalActionId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalActionIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(legalActionId, _that.getLegalActionId())) return false;
			if (!ListEquals.listEquals(versionedLegalActionId, _that.getVersionedLegalActionId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (legalActionId != null ? legalActionId.hashCode() : 0);
			_result = 31 * _result + (versionedLegalActionId != null ? versionedLegalActionId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalActionIdentifier {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"partyReference=" + this.partyReference + ", " +
				"legalActionId=" + this.legalActionId + ", " +
				"versionedLegalActionId=" + this.versionedLegalActionId +
			'}';
		}
	}

	/*********************** Builder Implementation of LegalActionIdentifier  ***********************/
	class LegalActionIdentifierBuilderImpl implements LegalActionIdentifier.LegalActionIdentifierBuilder {
	
		protected String id;
		protected String name;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<LegalActionId.LegalActionIdBuilder> legalActionId = new ArrayList<>();
		protected List<VersionedLegalActionId.VersionedLegalActionIdBuilder> versionedLegalActionId = new ArrayList<>();
		
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
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("legalActionId")
		public List<? extends LegalActionId.LegalActionIdBuilder> getLegalActionId() {
			return legalActionId;
		}
		
		@Override
		public LegalActionId.LegalActionIdBuilder getOrCreateLegalActionId(int index) {
			if (legalActionId==null) {
				this.legalActionId = new ArrayList<>();
			}
			return getIndex(legalActionId, index, () -> {
						LegalActionId.LegalActionIdBuilder newLegalActionId = LegalActionId.builder();
						return newLegalActionId;
					});
		}
		
		@Override
		@RosettaAttribute("versionedLegalActionId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("versionedLegalActionId")
		public List<? extends VersionedLegalActionId.VersionedLegalActionIdBuilder> getVersionedLegalActionId() {
			return versionedLegalActionId;
		}
		
		@Override
		public VersionedLegalActionId.VersionedLegalActionIdBuilder getOrCreateVersionedLegalActionId(int index) {
			if (versionedLegalActionId==null) {
				this.versionedLegalActionId = new ArrayList<>();
			}
			return getIndex(versionedLegalActionId, index, () -> {
						VersionedLegalActionId.VersionedLegalActionIdBuilder newVersionedLegalActionId = VersionedLegalActionId.builder();
						return newVersionedLegalActionId;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legalActionId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("legalActionId")
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder addLegalActionId(LegalActionId _legalActionId) {
			if (_legalActionId != null) {
				this.legalActionId.add(_legalActionId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder addLegalActionId(LegalActionId _legalActionId, int idx) {
			getIndex(this.legalActionId, idx, () -> _legalActionId.toBuilder());
			return this;
		}
		
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder addLegalActionId(List<? extends LegalActionId> legalActionIds) {
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
		public LegalActionIdentifier.LegalActionIdentifierBuilder setLegalActionId(List<? extends LegalActionId> legalActionIds) {
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
		public LegalActionIdentifier.LegalActionIdentifierBuilder addVersionedLegalActionId(VersionedLegalActionId _versionedLegalActionId) {
			if (_versionedLegalActionId != null) {
				this.versionedLegalActionId.add(_versionedLegalActionId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder addVersionedLegalActionId(VersionedLegalActionId _versionedLegalActionId, int idx) {
			getIndex(this.versionedLegalActionId, idx, () -> _versionedLegalActionId.toBuilder());
			return this;
		}
		
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder addVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionIds) {
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
		public LegalActionIdentifier.LegalActionIdentifierBuilder setVersionedLegalActionId(List<? extends VersionedLegalActionId> versionedLegalActionIds) {
			if (versionedLegalActionIds == null) {
				this.versionedLegalActionId = new ArrayList<>();
			} else {
				this.versionedLegalActionId = versionedLegalActionIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LegalActionIdentifier build() {
			return new LegalActionIdentifier.LegalActionIdentifierImpl(this);
		}
		
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			legalActionId = legalActionId.stream().filter(b->b!=null).<LegalActionId.LegalActionIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			versionedLegalActionId = versionedLegalActionId.stream().filter(b->b!=null).<VersionedLegalActionId.VersionedLegalActionIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getLegalActionId()!=null && getLegalActionId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getVersionedLegalActionId()!=null && getVersionedLegalActionId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalActionIdentifier.LegalActionIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalActionIdentifier.LegalActionIdentifierBuilder o = (LegalActionIdentifier.LegalActionIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getLegalActionId(), o.getLegalActionId(), this::getOrCreateLegalActionId);
			merger.mergeRosetta(getVersionedLegalActionId(), o.getVersionedLegalActionId(), this::getOrCreateVersionedLegalActionId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalActionIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(legalActionId, _that.getLegalActionId())) return false;
			if (!ListEquals.listEquals(versionedLegalActionId, _that.getVersionedLegalActionId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (legalActionId != null ? legalActionId.hashCode() : 0);
			_result = 31 * _result + (versionedLegalActionId != null ? versionedLegalActionId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalActionIdentifierBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"partyReference=" + this.partyReference + ", " +
				"legalActionId=" + this.legalActionId + ", " +
				"versionedLegalActionId=" + this.versionedLegalActionId +
			'}';
		}
	}
}
