package fpml.consolidated.doc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.doc.meta.VersionedContractIdMeta;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Contract Id with Version Support
 *
 */
@RosettaDataType(value="VersionedContractId", builder=VersionedContractId.VersionedContractIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VersionedContractId", model="fpml", builder=VersionedContractId.VersionedContractIdBuilderImpl.class, version="2.1.1")
public interface VersionedContractId extends RosettaModelObject {

	VersionedContractIdMeta metaData = new VersionedContractIdMeta();

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
	ContractId getContractId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The version number
	 *
	 */
	Integer getVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optionally it is possible to specify a version effective date when a versionId is supplied.
	 *
	 */
	IdentifiedDate getEffectiveDate();

	/*********************** Build Methods  ***********************/
	VersionedContractId build();
	
	VersionedContractId.VersionedContractIdBuilder toBuilder();
	
	static VersionedContractId.VersionedContractIdBuilder builder() {
		return new VersionedContractId.VersionedContractIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VersionedContractId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VersionedContractId> getType() {
		return VersionedContractId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contractId"), processor, ContractId.class, getContractId());
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.class, getEffectiveDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VersionedContractIdBuilder extends VersionedContractId, RosettaModelObjectBuilder {
		ContractId.ContractIdBuilder getOrCreateContractId();
		@Override
		ContractId.ContractIdBuilder getContractId();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getEffectiveDate();
		VersionedContractId.VersionedContractIdBuilder setContractId(ContractId contractId);
		VersionedContractId.VersionedContractIdBuilder setVersion(Integer version);
		VersionedContractId.VersionedContractIdBuilder setEffectiveDate(IdentifiedDate effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contractId"), processor, ContractId.ContractIdBuilder.class, getContractId());
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEffectiveDate());
		}
		

		VersionedContractId.VersionedContractIdBuilder prune();
	}

	/*********************** Immutable Implementation of VersionedContractId  ***********************/
	class VersionedContractIdImpl implements VersionedContractId {
		private final ContractId contractId;
		private final Integer version;
		private final IdentifiedDate effectiveDate;
		
		protected VersionedContractIdImpl(VersionedContractId.VersionedContractIdBuilder builder) {
			this.contractId = ofNullable(builder.getContractId()).map(f->f.build()).orElse(null);
			this.version = builder.getVersion();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("contractId")
		public ContractId getContractId() {
			return contractId;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("version")
		public Integer getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public IdentifiedDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public VersionedContractId build() {
			return this;
		}
		
		@Override
		public VersionedContractId.VersionedContractIdBuilder toBuilder() {
			VersionedContractId.VersionedContractIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VersionedContractId.VersionedContractIdBuilder builder) {
			ofNullable(getContractId()).ifPresent(builder::setContractId);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedContractId _that = getType().cast(o);
		
			if (!Objects.equals(contractId, _that.getContractId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractId != null ? contractId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedContractId {" +
				"contractId=" + this.contractId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of VersionedContractId  ***********************/
	class VersionedContractIdBuilderImpl implements VersionedContractId.VersionedContractIdBuilder {
	
		protected ContractId.ContractIdBuilder contractId;
		protected Integer version;
		protected IdentifiedDate.IdentifiedDateBuilder effectiveDate;
		
		@Override
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("contractId")
		public ContractId.ContractIdBuilder getContractId() {
			return contractId;
		}
		
		@Override
		public ContractId.ContractIdBuilder getOrCreateContractId() {
			ContractId.ContractIdBuilder result;
			if (contractId!=null) {
				result = contractId;
			}
			else {
				result = contractId = ContractId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("version")
		public Integer getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public IdentifiedDate.IdentifiedDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("contractId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("contractId")
		@Override
		public VersionedContractId.VersionedContractIdBuilder setContractId(ContractId _contractId) {
			this.contractId = _contractId == null ? null : _contractId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("version")
		@Override
		public VersionedContractId.VersionedContractIdBuilder setVersion(Integer _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public VersionedContractId.VersionedContractIdBuilder setEffectiveDate(IdentifiedDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		public VersionedContractId build() {
			return new VersionedContractId.VersionedContractIdImpl(this);
		}
		
		@Override
		public VersionedContractId.VersionedContractIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedContractId.VersionedContractIdBuilder prune() {
			if (contractId!=null && !contractId.prune().hasData()) contractId = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractId()!=null && getContractId().hasData()) return true;
			if (getVersion()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionedContractId.VersionedContractIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VersionedContractId.VersionedContractIdBuilder o = (VersionedContractId.VersionedContractIdBuilder) other;
			
			merger.mergeRosetta(getContractId(), o.getContractId(), this::setContractId);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionedContractId _that = getType().cast(o);
		
			if (!Objects.equals(contractId, _that.getContractId())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractId != null ? contractId.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionedContractIdBuilder {" +
				"contractId=" + this.contractId + ", " +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
