package cdm.observable.asset.fro;

import cdm.base.staticdata.identifier.Identifier;
import cdm.observable.asset.fro.meta.ContractualDefinitionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 6.23.0
 */
@RosettaDataType(value="ContractualDefinition", builder=ContractualDefinition.ContractualDefinitionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ContractualDefinition", model="cdm", builder=ContractualDefinition.ContractualDefinitionBuilderImpl.class, version="6.23.0")
public interface ContractualDefinition extends RosettaModelObject {

	ContractualDefinitionMeta metaData = new ContractualDefinitionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Corresponds to the unique identifier of the Contractual Definition in which the code is published
	 */
	Identifier getIdentifier();
	/**
	 * Contractual Definition Identifier in which the code is published. Includes Document Type and Document Version
	 */
	ContractualDefinitionIdentifier getContractualDefinitionIdentifier();
	/**
	 * 2021-06-11
	 */
	Date getPublicationDate();

	/*********************** Build Methods  ***********************/
	ContractualDefinition build();
	
	ContractualDefinition.ContractualDefinitionBuilder toBuilder();
	
	static ContractualDefinition.ContractualDefinitionBuilder builder() {
		return new ContractualDefinition.ContractualDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractualDefinition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractualDefinition> getType() {
		return ContractualDefinition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, Identifier.class, getIdentifier());
		processRosetta(path.newSubPath("contractualDefinitionIdentifier"), processor, ContractualDefinitionIdentifier.class, getContractualDefinitionIdentifier());
		processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractualDefinitionBuilder extends ContractualDefinition, RosettaModelObjectBuilder {
		Identifier.IdentifierBuilder getOrCreateIdentifier();
		@Override
		Identifier.IdentifierBuilder getIdentifier();
		ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder getOrCreateContractualDefinitionIdentifier();
		@Override
		ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder getContractualDefinitionIdentifier();
		ContractualDefinition.ContractualDefinitionBuilder setIdentifier(Identifier identifier);
		ContractualDefinition.ContractualDefinitionBuilder setContractualDefinitionIdentifier(ContractualDefinitionIdentifier contractualDefinitionIdentifier);
		ContractualDefinition.ContractualDefinitionBuilder setPublicationDate(Date publicationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, Identifier.IdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("contractualDefinitionIdentifier"), processor, ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder.class, getContractualDefinitionIdentifier());
			processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
		}
		

		ContractualDefinition.ContractualDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of ContractualDefinition  ***********************/
	class ContractualDefinitionImpl implements ContractualDefinition {
		private final Identifier identifier;
		private final ContractualDefinitionIdentifier contractualDefinitionIdentifier;
		private final Date publicationDate;
		
		protected ContractualDefinitionImpl(ContractualDefinition.ContractualDefinitionBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.contractualDefinitionIdentifier = ofNullable(builder.getContractualDefinitionIdentifier()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public Identifier getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractualDefinitionIdentifier")
		public ContractualDefinitionIdentifier getContractualDefinitionIdentifier() {
			return contractualDefinitionIdentifier;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationDate")
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		public ContractualDefinition build() {
			return this;
		}
		
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder toBuilder() {
			ContractualDefinition.ContractualDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualDefinition.ContractualDefinitionBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getContractualDefinitionIdentifier()).ifPresent(builder::setContractualDefinitionIdentifier);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualDefinition _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(contractualDefinitionIdentifier, _that.getContractualDefinitionIdentifier())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitionIdentifier != null ? contractualDefinitionIdentifier.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualDefinition {" +
				"identifier=" + this.identifier + ", " +
				"contractualDefinitionIdentifier=" + this.contractualDefinitionIdentifier + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractualDefinition  ***********************/
	class ContractualDefinitionBuilderImpl implements ContractualDefinition.ContractualDefinitionBuilder {
	
		protected Identifier.IdentifierBuilder identifier;
		protected ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder contractualDefinitionIdentifier;
		protected Date publicationDate;
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public Identifier.IdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public Identifier.IdentifierBuilder getOrCreateIdentifier() {
			Identifier.IdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = Identifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractualDefinitionIdentifier")
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder getContractualDefinitionIdentifier() {
			return contractualDefinitionIdentifier;
		}
		
		@Override
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder getOrCreateContractualDefinitionIdentifier() {
			ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder result;
			if (contractualDefinitionIdentifier!=null) {
				result = contractualDefinitionIdentifier;
			}
			else {
				result = contractualDefinitionIdentifier = ContractualDefinitionIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationDate")
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("identifier")
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder setIdentifier(Identifier _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractualDefinitionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractualDefinitionIdentifier")
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder setContractualDefinitionIdentifier(ContractualDefinitionIdentifier _contractualDefinitionIdentifier) {
			this.contractualDefinitionIdentifier = _contractualDefinitionIdentifier == null ? null : _contractualDefinitionIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publicationDate")
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder setPublicationDate(Date _publicationDate) {
			this.publicationDate = _publicationDate == null ? null : _publicationDate;
			return this;
		}
		
		@Override
		public ContractualDefinition build() {
			return new ContractualDefinition.ContractualDefinitionImpl(this);
		}
		
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (contractualDefinitionIdentifier!=null && !contractualDefinitionIdentifier.prune().hasData()) contractualDefinitionIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			if (getContractualDefinitionIdentifier()!=null && getContractualDefinitionIdentifier().hasData()) return true;
			if (getPublicationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualDefinition.ContractualDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualDefinition.ContractualDefinitionBuilder o = (ContractualDefinition.ContractualDefinitionBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getContractualDefinitionIdentifier(), o.getContractualDefinitionIdentifier(), this::setContractualDefinitionIdentifier);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualDefinition _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(contractualDefinitionIdentifier, _that.getContractualDefinitionIdentifier())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitionIdentifier != null ? contractualDefinitionIdentifier.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualDefinitionBuilder {" +
				"identifier=" + this.identifier + ", " +
				"contractualDefinitionIdentifier=" + this.contractualDefinitionIdentifier + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
}
