package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ContractIdentifierMeta;
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
 * Provision A type defining a contract identifier issued by the indicated party.
 *
 */
@RosettaDataType(value="ContractIdentifier", builder=ContractIdentifier.ContractIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ContractIdentifier", model="fpml", builder=ContractIdentifier.ContractIdentifierBuilderImpl.class, version="2.1.1")
public interface ContractIdentifier extends RosettaModelObject {

	ContractIdentifierMeta metaData = new ContractIdentifierMeta();

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
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. The party referenced has allocated the contract identifier.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A contract id which is not version aware.
	 *
	 */
	List<? extends ContractId> getContractId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A contract id which is version aware.
	 *
	 */
	List<? extends VersionedContractId> getVersionedContractId();

	/*********************** Build Methods  ***********************/
	ContractIdentifier build();
	
	ContractIdentifier.ContractIdentifierBuilder toBuilder();
	
	static ContractIdentifier.ContractIdentifierBuilder builder() {
		return new ContractIdentifier.ContractIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractIdentifier> getType() {
		return ContractIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("contractId"), processor, ContractId.class, getContractId());
		processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.class, getVersionedContractId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractIdentifierBuilder extends ContractIdentifier, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		ContractId.ContractIdBuilder getOrCreateContractId(int index);
		@Override
		List<? extends ContractId.ContractIdBuilder> getContractId();
		VersionedContractId.VersionedContractIdBuilder getOrCreateVersionedContractId(int index);
		@Override
		List<? extends VersionedContractId.VersionedContractIdBuilder> getVersionedContractId();
		ContractIdentifier.ContractIdentifierBuilder setId(String id);
		ContractIdentifier.ContractIdentifierBuilder setPartyReference(PartyReference partyReference);
		ContractIdentifier.ContractIdentifierBuilder addContractId(ContractId contractId);
		ContractIdentifier.ContractIdentifierBuilder addContractId(ContractId contractId, int idx);
		ContractIdentifier.ContractIdentifierBuilder addContractId(List<? extends ContractId> contractId);
		ContractIdentifier.ContractIdentifierBuilder setContractId(List<? extends ContractId> contractId);
		ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId);
		ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId, int idx);
		ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		ContractIdentifier.ContractIdentifierBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("contractId"), processor, ContractId.ContractIdBuilder.class, getContractId());
			processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.VersionedContractIdBuilder.class, getVersionedContractId());
		}
		

		ContractIdentifier.ContractIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of ContractIdentifier  ***********************/
	class ContractIdentifierImpl implements ContractIdentifier {
		private final String id;
		private final PartyReference partyReference;
		private final List<? extends ContractId> contractId;
		private final List<? extends VersionedContractId> versionedContractId;
		
		protected ContractIdentifierImpl(ContractIdentifier.ContractIdentifierBuilder builder) {
			this.id = builder.getId();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.contractId = ofNullable(builder.getContractId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.versionedContractId = ofNullable(builder.getVersionedContractId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
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
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractId")
		public List<? extends ContractId> getContractId() {
			return contractId;
		}
		
		@Override
		@RosettaAttribute("versionedContractId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("versionedContractId")
		public List<? extends VersionedContractId> getVersionedContractId() {
			return versionedContractId;
		}
		
		@Override
		public ContractIdentifier build() {
			return this;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder toBuilder() {
			ContractIdentifier.ContractIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractIdentifier.ContractIdentifierBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getContractId()).ifPresent(builder::setContractId);
			ofNullable(getVersionedContractId()).ifPresent(builder::setVersionedContractId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(contractId, _that.getContractId())) return false;
			if (!ListEquals.listEquals(versionedContractId, _that.getVersionedContractId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (contractId != null ? contractId.hashCode() : 0);
			_result = 31 * _result + (versionedContractId != null ? versionedContractId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractIdentifier {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"contractId=" + this.contractId + ", " +
				"versionedContractId=" + this.versionedContractId +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractIdentifier  ***********************/
	class ContractIdentifierBuilderImpl implements ContractIdentifier.ContractIdentifierBuilder {
	
		protected String id;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<ContractId.ContractIdBuilder> contractId = new ArrayList<>();
		protected List<VersionedContractId.VersionedContractIdBuilder> versionedContractId = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
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
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractId")
		public List<? extends ContractId.ContractIdBuilder> getContractId() {
			return contractId;
		}
		
		@Override
		public ContractId.ContractIdBuilder getOrCreateContractId(int index) {
			if (contractId==null) {
				this.contractId = new ArrayList<>();
			}
			return getIndex(contractId, index, () -> {
						ContractId.ContractIdBuilder newContractId = ContractId.builder();
						return newContractId;
					});
		}
		
		@Override
		@RosettaAttribute("versionedContractId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("versionedContractId")
		public List<? extends VersionedContractId.VersionedContractIdBuilder> getVersionedContractId() {
			return versionedContractId;
		}
		
		@Override
		public VersionedContractId.VersionedContractIdBuilder getOrCreateVersionedContractId(int index) {
			if (versionedContractId==null) {
				this.versionedContractId = new ArrayList<>();
			}
			return getIndex(versionedContractId, index, () -> {
						VersionedContractId.VersionedContractIdBuilder newVersionedContractId = VersionedContractId.builder();
						return newVersionedContractId;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ContractIdentifier.ContractIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public ContractIdentifier.ContractIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractId")
		@Override
		public ContractIdentifier.ContractIdentifierBuilder addContractId(ContractId _contractId) {
			if (_contractId != null) {
				this.contractId.add(_contractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder addContractId(ContractId _contractId, int idx) {
			getIndex(this.contractId, idx, () -> _contractId.toBuilder());
			return this;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder addContractId(List<? extends ContractId> contractIds) {
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
		public ContractIdentifier.ContractIdentifierBuilder setContractId(List<? extends ContractId> contractIds) {
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
		public ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(VersionedContractId _versionedContractId) {
			if (_versionedContractId != null) {
				this.versionedContractId.add(_versionedContractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(VersionedContractId _versionedContractId, int idx) {
			getIndex(this.versionedContractId, idx, () -> _versionedContractId.toBuilder());
			return this;
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public ContractIdentifier.ContractIdentifierBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
			if (versionedContractIds == null) {
				this.versionedContractId = new ArrayList<>();
			} else {
				this.versionedContractId = versionedContractIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ContractIdentifier build() {
			return new ContractIdentifier.ContractIdentifierImpl(this);
		}
		
		@Override
		public ContractIdentifier.ContractIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractIdentifier.ContractIdentifierBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			contractId = contractId.stream().filter(b->b!=null).<ContractId.ContractIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			versionedContractId = versionedContractId.stream().filter(b->b!=null).<VersionedContractId.VersionedContractIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getContractId()!=null && getContractId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getVersionedContractId()!=null && getVersionedContractId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractIdentifier.ContractIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractIdentifier.ContractIdentifierBuilder o = (ContractIdentifier.ContractIdentifierBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getContractId(), o.getContractId(), this::getOrCreateContractId);
			merger.mergeRosetta(getVersionedContractId(), o.getVersionedContractId(), this::getOrCreateVersionedContractId);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(contractId, _that.getContractId())) return false;
			if (!ListEquals.listEquals(versionedContractId, _that.getVersionedContractId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (contractId != null ? contractId.hashCode() : 0);
			_result = 31 * _result + (versionedContractId != null ? versionedContractId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractIdentifierBuilder {" +
				"id=" + this.id + ", " +
				"partyReference=" + this.partyReference + ", " +
				"contractId=" + this.contractId + ", " +
				"versionedContractId=" + this.versionedContractId +
			'}';
		}
	}
}
