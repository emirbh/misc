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
import fpml.consolidated.doc.ContractIdentifier;
import fpml.consolidated.doc.VersionedContractId;
import fpml.consolidated.loan.meta.LoanContractIdentifierMeta;
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
 * Provision A unique identifier for outstanding loan contracts.
 *
 */
@RosettaDataType(value="LoanContractIdentifier", builder=LoanContractIdentifier.LoanContractIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContractIdentifier", model="fpml", builder=LoanContractIdentifier.LoanContractIdentifierBuilderImpl.class, version="2.1.1")
public interface LoanContractIdentifier extends ContractIdentifier {

	LoanContractIdentifierMeta metaData = new LoanContractIdentifierMeta();

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
	FacilityReference getFacilityReference();

	/*********************** Build Methods  ***********************/
	LoanContractIdentifier build();
	
	LoanContractIdentifier.LoanContractIdentifierBuilder toBuilder();
	
	static LoanContractIdentifier.LoanContractIdentifierBuilder builder() {
		return new LoanContractIdentifier.LoanContractIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContractIdentifier> getType() {
		return LoanContractIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("contractId"), processor, ContractId.class, getContractId());
		processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.class, getVersionedContractId());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractIdentifierBuilder extends LoanContractIdentifier, ContractIdentifier.ContractIdentifierBuilder {
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		@Override
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder setId(String id);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder addContractId(ContractId contractId);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder addContractId(ContractId contractId, int idx);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder addContractId(List<? extends ContractId> contractId);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder setContractId(List<? extends ContractId> contractId);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder addVersionedContractId(VersionedContractId versionedContractId, int idx);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractId);
		LoanContractIdentifier.LoanContractIdentifierBuilder setFacilityReference(FacilityReference facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("contractId"), processor, ContractId.ContractIdBuilder.class, getContractId());
			processRosetta(path.newSubPath("versionedContractId"), processor, VersionedContractId.VersionedContractIdBuilder.class, getVersionedContractId());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		LoanContractIdentifier.LoanContractIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractIdentifier  ***********************/
	class LoanContractIdentifierImpl extends ContractIdentifier.ContractIdentifierImpl implements LoanContractIdentifier {
		private final FacilityReference facilityReference;
		
		protected LoanContractIdentifierImpl(LoanContractIdentifier.LoanContractIdentifierBuilder builder) {
			super(builder);
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public LoanContractIdentifier build() {
			return this;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder toBuilder() {
			LoanContractIdentifier.LoanContractIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractIdentifier.LoanContractIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractIdentifier {" +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractIdentifier  ***********************/
	class LoanContractIdentifierBuilderImpl extends ContractIdentifier.ContractIdentifierBuilderImpl implements LoanContractIdentifier.LoanContractIdentifierBuilder {
	
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractId")
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder addContractId(ContractId _contractId) {
			if (_contractId != null) {
				this.contractId.add(_contractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder addContractId(ContractId _contractId, int idx) {
			getIndex(this.contractId, idx, () -> _contractId.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder addContractId(List<? extends ContractId> contractIds) {
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
		public LoanContractIdentifier.LoanContractIdentifierBuilder setContractId(List<? extends ContractId> contractIds) {
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
		public LoanContractIdentifier.LoanContractIdentifierBuilder addVersionedContractId(VersionedContractId _versionedContractId) {
			if (_versionedContractId != null) {
				this.versionedContractId.add(_versionedContractId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder addVersionedContractId(VersionedContractId _versionedContractId, int idx) {
			getIndex(this.versionedContractId, idx, () -> _versionedContractId.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder addVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public LoanContractIdentifier.LoanContractIdentifierBuilder setVersionedContractId(List<? extends VersionedContractId> versionedContractIds) {
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
		public LoanContractIdentifier.LoanContractIdentifierBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanContractIdentifier build() {
			return new LoanContractIdentifier.LoanContractIdentifierImpl(this);
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder prune() {
			super.prune();
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanContractIdentifier.LoanContractIdentifierBuilder o = (LoanContractIdentifier.LoanContractIdentifierBuilder) other;
			
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractIdentifierBuilder {" +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}
}
