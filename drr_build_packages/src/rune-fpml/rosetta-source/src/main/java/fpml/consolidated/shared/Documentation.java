package fpml.consolidated.shared;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.shared.meta.DocumentationMeta;
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
 * version "recordkeeping-5.13"
 *
 * Provision An entity for defining the definitions that govern the document and should include the year and type of definitions referenced, along with any relevant documentation (such as master agreement) and the date it was signed.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An entity for defining the definitions that govern the document and should include the year and type of definitions referenced, along with any relevant documentation (such as master agreement) and the date it was signed.
 *
 */
@RosettaDataType(value="Documentation", builder=Documentation.DocumentationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Documentation", model="fpml", builder=Documentation.DocumentationBuilderImpl.class, version="2.1.1")
public interface Documentation extends RosettaModelObject {

	DocumentationMeta metaData = new DocumentationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
	 *
	 */
	MasterAgreement getMasterAgreement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern all OTC derivatives transactions between those parties.
	 *
	 */
	MasterConfirmation getMasterConfirmation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the deails for a broker confirm.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the deails for a broker confirm.
	 *
	 */
	BrokerConfirmation getBrokerConfirmation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The definitions such as those published by ISDA that will define the terms of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The definitions such as those published by ISDA that will define the terms of the trade.
	 *
	 */
	List<? extends ContractualDefinitions> getContractualDefinitions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A contractual supplement (such as those published by ISDA) that will apply to the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A contractual supplement (such as those published by ISDA) that will apply to the trade.
	 *
	 */
	List<? extends ContractualTermsSupplement> getContractualTermsSupplement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to a contractual matrix of elected terms/values (such as those published by ISDA) that shall be deemed to apply to the trade. The applicable matrix is identified by reference to a name and optionally a publication date. Depending on the structure of the matrix, an additional term (specified in the matrixTerm element) may be required to further identify a subset of applicable terms/values within the matrix.
	 *
	 */
	List<? extends ContractualMatrix> getContractualMatrix();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern collateral arrangement for all OTC derivatives transactions between those parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The agreement executed between the parties and intended to govern collateral arrangement for all OTC derivatives transactions between those parties.
	 *
	 */
	CreditSupportAgreement getCreditSupportAgreement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Any other agreement executed between the parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Any other agreement executed between the parties.
	 *
	 */
	List<? extends OtherAgreement> getOtherAgreement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A human readable document related to this transaction, for example a confirmation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A human readable document related to this transaction, for example a confirmation.
	 *
	 */
	List<? extends Resource> getAttachment();

	/*********************** Build Methods  ***********************/
	Documentation build();
	
	Documentation.DocumentationBuilder toBuilder();
	
	static Documentation.DocumentationBuilder builder() {
		return new Documentation.DocumentationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Documentation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Documentation> getType() {
		return Documentation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("masterAgreement"), processor, MasterAgreement.class, getMasterAgreement());
		processRosetta(path.newSubPath("masterConfirmation"), processor, MasterConfirmation.class, getMasterConfirmation());
		processRosetta(path.newSubPath("brokerConfirmation"), processor, BrokerConfirmation.class, getBrokerConfirmation());
		processRosetta(path.newSubPath("contractualDefinitions"), processor, ContractualDefinitions.class, getContractualDefinitions());
		processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.class, getContractualTermsSupplement());
		processRosetta(path.newSubPath("contractualMatrix"), processor, ContractualMatrix.class, getContractualMatrix());
		processRosetta(path.newSubPath("creditSupportAgreement"), processor, CreditSupportAgreement.class, getCreditSupportAgreement());
		processRosetta(path.newSubPath("otherAgreement"), processor, OtherAgreement.class, getOtherAgreement());
		processRosetta(path.newSubPath("attachment"), processor, Resource.class, getAttachment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DocumentationBuilder extends Documentation, RosettaModelObjectBuilder {
		MasterAgreement.MasterAgreementBuilder getOrCreateMasterAgreement();
		@Override
		MasterAgreement.MasterAgreementBuilder getMasterAgreement();
		MasterConfirmation.MasterConfirmationBuilder getOrCreateMasterConfirmation();
		@Override
		MasterConfirmation.MasterConfirmationBuilder getMasterConfirmation();
		BrokerConfirmation.BrokerConfirmationBuilder getOrCreateBrokerConfirmation();
		@Override
		BrokerConfirmation.BrokerConfirmationBuilder getBrokerConfirmation();
		ContractualDefinitions.ContractualDefinitionsBuilder getOrCreateContractualDefinitions(int index);
		@Override
		List<? extends ContractualDefinitions.ContractualDefinitionsBuilder> getContractualDefinitions();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int index);
		@Override
		List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement();
		ContractualMatrix.ContractualMatrixBuilder getOrCreateContractualMatrix(int index);
		@Override
		List<? extends ContractualMatrix.ContractualMatrixBuilder> getContractualMatrix();
		CreditSupportAgreement.CreditSupportAgreementBuilder getOrCreateCreditSupportAgreement();
		@Override
		CreditSupportAgreement.CreditSupportAgreementBuilder getCreditSupportAgreement();
		OtherAgreement.OtherAgreementBuilder getOrCreateOtherAgreement(int index);
		@Override
		List<? extends OtherAgreement.OtherAgreementBuilder> getOtherAgreement();
		Resource.ResourceBuilder getOrCreateAttachment(int index);
		@Override
		List<? extends Resource.ResourceBuilder> getAttachment();
		Documentation.DocumentationBuilder setMasterAgreement(MasterAgreement masterAgreement);
		Documentation.DocumentationBuilder setMasterConfirmation(MasterConfirmation masterConfirmation);
		Documentation.DocumentationBuilder setBrokerConfirmation(BrokerConfirmation brokerConfirmation);
		Documentation.DocumentationBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions);
		Documentation.DocumentationBuilder addContractualDefinitions(ContractualDefinitions contractualDefinitions, int idx);
		Documentation.DocumentationBuilder addContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitions);
		Documentation.DocumentationBuilder setContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitions);
		Documentation.DocumentationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement);
		Documentation.DocumentationBuilder addContractualTermsSupplement(ContractualTermsSupplement contractualTermsSupplement, int idx);
		Documentation.DocumentationBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement);
		Documentation.DocumentationBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplement);
		Documentation.DocumentationBuilder addContractualMatrix(ContractualMatrix contractualMatrix);
		Documentation.DocumentationBuilder addContractualMatrix(ContractualMatrix contractualMatrix, int idx);
		Documentation.DocumentationBuilder addContractualMatrix(List<? extends ContractualMatrix> contractualMatrix);
		Documentation.DocumentationBuilder setContractualMatrix(List<? extends ContractualMatrix> contractualMatrix);
		Documentation.DocumentationBuilder setCreditSupportAgreement(CreditSupportAgreement creditSupportAgreement);
		Documentation.DocumentationBuilder addOtherAgreement(OtherAgreement otherAgreement);
		Documentation.DocumentationBuilder addOtherAgreement(OtherAgreement otherAgreement, int idx);
		Documentation.DocumentationBuilder addOtherAgreement(List<? extends OtherAgreement> otherAgreement);
		Documentation.DocumentationBuilder setOtherAgreement(List<? extends OtherAgreement> otherAgreement);
		Documentation.DocumentationBuilder addAttachment(Resource attachment);
		Documentation.DocumentationBuilder addAttachment(Resource attachment, int idx);
		Documentation.DocumentationBuilder addAttachment(List<? extends Resource> attachment);
		Documentation.DocumentationBuilder setAttachment(List<? extends Resource> attachment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("masterAgreement"), processor, MasterAgreement.MasterAgreementBuilder.class, getMasterAgreement());
			processRosetta(path.newSubPath("masterConfirmation"), processor, MasterConfirmation.MasterConfirmationBuilder.class, getMasterConfirmation());
			processRosetta(path.newSubPath("brokerConfirmation"), processor, BrokerConfirmation.BrokerConfirmationBuilder.class, getBrokerConfirmation());
			processRosetta(path.newSubPath("contractualDefinitions"), processor, ContractualDefinitions.ContractualDefinitionsBuilder.class, getContractualDefinitions());
			processRosetta(path.newSubPath("contractualTermsSupplement"), processor, ContractualTermsSupplement.ContractualTermsSupplementBuilder.class, getContractualTermsSupplement());
			processRosetta(path.newSubPath("contractualMatrix"), processor, ContractualMatrix.ContractualMatrixBuilder.class, getContractualMatrix());
			processRosetta(path.newSubPath("creditSupportAgreement"), processor, CreditSupportAgreement.CreditSupportAgreementBuilder.class, getCreditSupportAgreement());
			processRosetta(path.newSubPath("otherAgreement"), processor, OtherAgreement.OtherAgreementBuilder.class, getOtherAgreement());
			processRosetta(path.newSubPath("attachment"), processor, Resource.ResourceBuilder.class, getAttachment());
		}
		

		Documentation.DocumentationBuilder prune();
	}

	/*********************** Immutable Implementation of Documentation  ***********************/
	class DocumentationImpl implements Documentation {
		private final MasterAgreement masterAgreement;
		private final MasterConfirmation masterConfirmation;
		private final BrokerConfirmation brokerConfirmation;
		private final List<? extends ContractualDefinitions> contractualDefinitions;
		private final List<? extends ContractualTermsSupplement> contractualTermsSupplement;
		private final List<? extends ContractualMatrix> contractualMatrix;
		private final CreditSupportAgreement creditSupportAgreement;
		private final List<? extends OtherAgreement> otherAgreement;
		private final List<? extends Resource> attachment;
		
		protected DocumentationImpl(Documentation.DocumentationBuilder builder) {
			this.masterAgreement = ofNullable(builder.getMasterAgreement()).map(f->f.build()).orElse(null);
			this.masterConfirmation = ofNullable(builder.getMasterConfirmation()).map(f->f.build()).orElse(null);
			this.brokerConfirmation = ofNullable(builder.getBrokerConfirmation()).map(f->f.build()).orElse(null);
			this.contractualDefinitions = ofNullable(builder.getContractualDefinitions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualTermsSupplement = ofNullable(builder.getContractualTermsSupplement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contractualMatrix = ofNullable(builder.getContractualMatrix()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditSupportAgreement = ofNullable(builder.getCreditSupportAgreement()).map(f->f.build()).orElse(null);
			this.otherAgreement = ofNullable(builder.getOtherAgreement()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.attachment = ofNullable(builder.getAttachment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("masterAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreement")
		public MasterAgreement getMasterAgreement() {
			return masterAgreement;
		}
		
		@Override
		@RosettaAttribute("masterConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmation")
		public MasterConfirmation getMasterConfirmation() {
			return masterConfirmation;
		}
		
		@Override
		@RosettaAttribute("brokerConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerConfirmation")
		public BrokerConfirmation getBrokerConfirmation() {
			return brokerConfirmation;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualDefinitions")
		public List<? extends ContractualDefinitions> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		@RosettaAttribute("contractualMatrix")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualMatrix")
		public List<? extends ContractualMatrix> getContractualMatrix() {
			return contractualMatrix;
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditSupportAgreement")
		public CreditSupportAgreement getCreditSupportAgreement() {
			return creditSupportAgreement;
		}
		
		@Override
		@RosettaAttribute("otherAgreement")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherAgreement")
		public List<? extends OtherAgreement> getOtherAgreement() {
			return otherAgreement;
		}
		
		@Override
		@RosettaAttribute("attachment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("attachment")
		public List<? extends Resource> getAttachment() {
			return attachment;
		}
		
		@Override
		public Documentation build() {
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder toBuilder() {
			Documentation.DocumentationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Documentation.DocumentationBuilder builder) {
			ofNullable(getMasterAgreement()).ifPresent(builder::setMasterAgreement);
			ofNullable(getMasterConfirmation()).ifPresent(builder::setMasterConfirmation);
			ofNullable(getBrokerConfirmation()).ifPresent(builder::setBrokerConfirmation);
			ofNullable(getContractualDefinitions()).ifPresent(builder::setContractualDefinitions);
			ofNullable(getContractualTermsSupplement()).ifPresent(builder::setContractualTermsSupplement);
			ofNullable(getContractualMatrix()).ifPresent(builder::setContractualMatrix);
			ofNullable(getCreditSupportAgreement()).ifPresent(builder::setCreditSupportAgreement);
			ofNullable(getOtherAgreement()).ifPresent(builder::setOtherAgreement);
			ofNullable(getAttachment()).ifPresent(builder::setAttachment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Documentation _that = getType().cast(o);
		
			if (!Objects.equals(masterAgreement, _that.getMasterAgreement())) return false;
			if (!Objects.equals(masterConfirmation, _that.getMasterConfirmation())) return false;
			if (!Objects.equals(brokerConfirmation, _that.getBrokerConfirmation())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!ListEquals.listEquals(contractualMatrix, _that.getContractualMatrix())) return false;
			if (!Objects.equals(creditSupportAgreement, _that.getCreditSupportAgreement())) return false;
			if (!ListEquals.listEquals(otherAgreement, _that.getOtherAgreement())) return false;
			if (!ListEquals.listEquals(attachment, _that.getAttachment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreement != null ? masterAgreement.hashCode() : 0);
			_result = 31 * _result + (masterConfirmation != null ? masterConfirmation.hashCode() : 0);
			_result = 31 * _result + (brokerConfirmation != null ? brokerConfirmation.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (contractualMatrix != null ? contractualMatrix.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreement != null ? creditSupportAgreement.hashCode() : 0);
			_result = 31 * _result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
			_result = 31 * _result + (attachment != null ? attachment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Documentation {" +
				"masterAgreement=" + this.masterAgreement + ", " +
				"masterConfirmation=" + this.masterConfirmation + ", " +
				"brokerConfirmation=" + this.brokerConfirmation + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"contractualMatrix=" + this.contractualMatrix + ", " +
				"creditSupportAgreement=" + this.creditSupportAgreement + ", " +
				"otherAgreement=" + this.otherAgreement + ", " +
				"attachment=" + this.attachment +
			'}';
		}
	}

	/*********************** Builder Implementation of Documentation  ***********************/
	class DocumentationBuilderImpl implements Documentation.DocumentationBuilder {
	
		protected MasterAgreement.MasterAgreementBuilder masterAgreement;
		protected MasterConfirmation.MasterConfirmationBuilder masterConfirmation;
		protected BrokerConfirmation.BrokerConfirmationBuilder brokerConfirmation;
		protected List<ContractualDefinitions.ContractualDefinitionsBuilder> contractualDefinitions = new ArrayList<>();
		protected List<ContractualTermsSupplement.ContractualTermsSupplementBuilder> contractualTermsSupplement = new ArrayList<>();
		protected List<ContractualMatrix.ContractualMatrixBuilder> contractualMatrix = new ArrayList<>();
		protected CreditSupportAgreement.CreditSupportAgreementBuilder creditSupportAgreement;
		protected List<OtherAgreement.OtherAgreementBuilder> otherAgreement = new ArrayList<>();
		protected List<Resource.ResourceBuilder> attachment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("masterAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreement")
		public MasterAgreement.MasterAgreementBuilder getMasterAgreement() {
			return masterAgreement;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder getOrCreateMasterAgreement() {
			MasterAgreement.MasterAgreementBuilder result;
			if (masterAgreement!=null) {
				result = masterAgreement;
			}
			else {
				result = masterAgreement = MasterAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterConfirmation")
		public MasterConfirmation.MasterConfirmationBuilder getMasterConfirmation() {
			return masterConfirmation;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder getOrCreateMasterConfirmation() {
			MasterConfirmation.MasterConfirmationBuilder result;
			if (masterConfirmation!=null) {
				result = masterConfirmation;
			}
			else {
				result = masterConfirmation = MasterConfirmation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("brokerConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerConfirmation")
		public BrokerConfirmation.BrokerConfirmationBuilder getBrokerConfirmation() {
			return brokerConfirmation;
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder getOrCreateBrokerConfirmation() {
			BrokerConfirmation.BrokerConfirmationBuilder result;
			if (brokerConfirmation!=null) {
				result = brokerConfirmation;
			}
			else {
				result = brokerConfirmation = BrokerConfirmation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualDefinitions")
		public List<? extends ContractualDefinitions.ContractualDefinitionsBuilder> getContractualDefinitions() {
			return contractualDefinitions;
		}
		
		@Override
		public ContractualDefinitions.ContractualDefinitionsBuilder getOrCreateContractualDefinitions(int index) {
			if (contractualDefinitions==null) {
				this.contractualDefinitions = new ArrayList<>();
			}
			return getIndex(contractualDefinitions, index, () -> {
						ContractualDefinitions.ContractualDefinitionsBuilder newContractualDefinitions = ContractualDefinitions.builder();
						return newContractualDefinitions;
					});
		}
		
		@Override
		@RosettaAttribute("contractualTermsSupplement")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualTermsSupplement")
		public List<? extends ContractualTermsSupplement.ContractualTermsSupplementBuilder> getContractualTermsSupplement() {
			return contractualTermsSupplement;
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder getOrCreateContractualTermsSupplement(int index) {
			if (contractualTermsSupplement==null) {
				this.contractualTermsSupplement = new ArrayList<>();
			}
			return getIndex(contractualTermsSupplement, index, () -> {
						ContractualTermsSupplement.ContractualTermsSupplementBuilder newContractualTermsSupplement = ContractualTermsSupplement.builder();
						return newContractualTermsSupplement;
					});
		}
		
		@Override
		@RosettaAttribute("contractualMatrix")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("contractualMatrix")
		public List<? extends ContractualMatrix.ContractualMatrixBuilder> getContractualMatrix() {
			return contractualMatrix;
		}
		
		@Override
		public ContractualMatrix.ContractualMatrixBuilder getOrCreateContractualMatrix(int index) {
			if (contractualMatrix==null) {
				this.contractualMatrix = new ArrayList<>();
			}
			return getIndex(contractualMatrix, index, () -> {
						ContractualMatrix.ContractualMatrixBuilder newContractualMatrix = ContractualMatrix.builder();
						return newContractualMatrix;
					});
		}
		
		@Override
		@RosettaAttribute("creditSupportAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditSupportAgreement")
		public CreditSupportAgreement.CreditSupportAgreementBuilder getCreditSupportAgreement() {
			return creditSupportAgreement;
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder getOrCreateCreditSupportAgreement() {
			CreditSupportAgreement.CreditSupportAgreementBuilder result;
			if (creditSupportAgreement!=null) {
				result = creditSupportAgreement;
			}
			else {
				result = creditSupportAgreement = CreditSupportAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherAgreement")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherAgreement")
		public List<? extends OtherAgreement.OtherAgreementBuilder> getOtherAgreement() {
			return otherAgreement;
		}
		
		@Override
		public OtherAgreement.OtherAgreementBuilder getOrCreateOtherAgreement(int index) {
			if (otherAgreement==null) {
				this.otherAgreement = new ArrayList<>();
			}
			return getIndex(otherAgreement, index, () -> {
						OtherAgreement.OtherAgreementBuilder newOtherAgreement = OtherAgreement.builder();
						return newOtherAgreement;
					});
		}
		
		@Override
		@RosettaAttribute("attachment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("attachment")
		public List<? extends Resource.ResourceBuilder> getAttachment() {
			return attachment;
		}
		
		@Override
		public Resource.ResourceBuilder getOrCreateAttachment(int index) {
			if (attachment==null) {
				this.attachment = new ArrayList<>();
			}
			return getIndex(attachment, index, () -> {
						Resource.ResourceBuilder newAttachment = Resource.builder();
						return newAttachment;
					});
		}
		
		@RosettaAttribute("masterAgreement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreement")
		@Override
		public Documentation.DocumentationBuilder setMasterAgreement(MasterAgreement _masterAgreement) {
			this.masterAgreement = _masterAgreement == null ? null : _masterAgreement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterConfirmation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterConfirmation")
		@Override
		public Documentation.DocumentationBuilder setMasterConfirmation(MasterConfirmation _masterConfirmation) {
			this.masterConfirmation = _masterConfirmation == null ? null : _masterConfirmation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("brokerConfirmation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerConfirmation")
		@Override
		public Documentation.DocumentationBuilder setBrokerConfirmation(BrokerConfirmation _brokerConfirmation) {
			this.brokerConfirmation = _brokerConfirmation == null ? null : _brokerConfirmation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractualDefinitions")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractualDefinitions")
		@Override
		public Documentation.DocumentationBuilder addContractualDefinitions(ContractualDefinitions _contractualDefinitions) {
			if (_contractualDefinitions != null) {
				this.contractualDefinitions.add(_contractualDefinitions.toBuilder());
			}
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualDefinitions(ContractualDefinitions _contractualDefinitions, int idx) {
			getIndex(this.contractualDefinitions, idx, () -> _contractualDefinitions.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitionss) {
			if (contractualDefinitionss != null) {
				for (final ContractualDefinitions toAdd : contractualDefinitionss) {
					this.contractualDefinitions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contractualDefinitions")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contractualDefinitions")
		@Override
		public Documentation.DocumentationBuilder setContractualDefinitions(List<? extends ContractualDefinitions> contractualDefinitionss) {
			if (contractualDefinitionss == null) {
				this.contractualDefinitions = new ArrayList<>();
			} else {
				this.contractualDefinitions = contractualDefinitionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("contractualTermsSupplement")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractualTermsSupplement")
		@Override
		public Documentation.DocumentationBuilder addContractualTermsSupplement(ContractualTermsSupplement _contractualTermsSupplement) {
			if (_contractualTermsSupplement != null) {
				this.contractualTermsSupplement.add(_contractualTermsSupplement.toBuilder());
			}
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualTermsSupplement(ContractualTermsSupplement _contractualTermsSupplement, int idx) {
			getIndex(this.contractualTermsSupplement, idx, () -> _contractualTermsSupplement.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements != null) {
				for (final ContractualTermsSupplement toAdd : contractualTermsSupplements) {
					this.contractualTermsSupplement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contractualTermsSupplement")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contractualTermsSupplement")
		@Override
		public Documentation.DocumentationBuilder setContractualTermsSupplement(List<? extends ContractualTermsSupplement> contractualTermsSupplements) {
			if (contractualTermsSupplements == null) {
				this.contractualTermsSupplement = new ArrayList<>();
			} else {
				this.contractualTermsSupplement = contractualTermsSupplements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("contractualMatrix")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("contractualMatrix")
		@Override
		public Documentation.DocumentationBuilder addContractualMatrix(ContractualMatrix _contractualMatrix) {
			if (_contractualMatrix != null) {
				this.contractualMatrix.add(_contractualMatrix.toBuilder());
			}
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualMatrix(ContractualMatrix _contractualMatrix, int idx) {
			getIndex(this.contractualMatrix, idx, () -> _contractualMatrix.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addContractualMatrix(List<? extends ContractualMatrix> contractualMatrixs) {
			if (contractualMatrixs != null) {
				for (final ContractualMatrix toAdd : contractualMatrixs) {
					this.contractualMatrix.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contractualMatrix")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("contractualMatrix")
		@Override
		public Documentation.DocumentationBuilder setContractualMatrix(List<? extends ContractualMatrix> contractualMatrixs) {
			if (contractualMatrixs == null) {
				this.contractualMatrix = new ArrayList<>();
			} else {
				this.contractualMatrix = contractualMatrixs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditSupportAgreement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditSupportAgreement")
		@Override
		public Documentation.DocumentationBuilder setCreditSupportAgreement(CreditSupportAgreement _creditSupportAgreement) {
			this.creditSupportAgreement = _creditSupportAgreement == null ? null : _creditSupportAgreement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherAgreement")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherAgreement")
		@Override
		public Documentation.DocumentationBuilder addOtherAgreement(OtherAgreement _otherAgreement) {
			if (_otherAgreement != null) {
				this.otherAgreement.add(_otherAgreement.toBuilder());
			}
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addOtherAgreement(OtherAgreement _otherAgreement, int idx) {
			getIndex(this.otherAgreement, idx, () -> _otherAgreement.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addOtherAgreement(List<? extends OtherAgreement> otherAgreements) {
			if (otherAgreements != null) {
				for (final OtherAgreement toAdd : otherAgreements) {
					this.otherAgreement.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherAgreement")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherAgreement")
		@Override
		public Documentation.DocumentationBuilder setOtherAgreement(List<? extends OtherAgreement> otherAgreements) {
			if (otherAgreements == null) {
				this.otherAgreement = new ArrayList<>();
			} else {
				this.otherAgreement = otherAgreements.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("attachment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("attachment")
		@Override
		public Documentation.DocumentationBuilder addAttachment(Resource _attachment) {
			if (_attachment != null) {
				this.attachment.add(_attachment.toBuilder());
			}
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addAttachment(Resource _attachment, int idx) {
			getIndex(this.attachment, idx, () -> _attachment.toBuilder());
			return this;
		}
		
		@Override
		public Documentation.DocumentationBuilder addAttachment(List<? extends Resource> attachments) {
			if (attachments != null) {
				for (final Resource toAdd : attachments) {
					this.attachment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("attachment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("attachment")
		@Override
		public Documentation.DocumentationBuilder setAttachment(List<? extends Resource> attachments) {
			if (attachments == null) {
				this.attachment = new ArrayList<>();
			} else {
				this.attachment = attachments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Documentation build() {
			return new Documentation.DocumentationImpl(this);
		}
		
		@Override
		public Documentation.DocumentationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Documentation.DocumentationBuilder prune() {
			if (masterAgreement!=null && !masterAgreement.prune().hasData()) masterAgreement = null;
			if (masterConfirmation!=null && !masterConfirmation.prune().hasData()) masterConfirmation = null;
			if (brokerConfirmation!=null && !brokerConfirmation.prune().hasData()) brokerConfirmation = null;
			contractualDefinitions = contractualDefinitions.stream().filter(b->b!=null).<ContractualDefinitions.ContractualDefinitionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualTermsSupplement = contractualTermsSupplement.stream().filter(b->b!=null).<ContractualTermsSupplement.ContractualTermsSupplementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			contractualMatrix = contractualMatrix.stream().filter(b->b!=null).<ContractualMatrix.ContractualMatrixBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (creditSupportAgreement!=null && !creditSupportAgreement.prune().hasData()) creditSupportAgreement = null;
			otherAgreement = otherAgreement.stream().filter(b->b!=null).<OtherAgreement.OtherAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			attachment = attachment.stream().filter(b->b!=null).<Resource.ResourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMasterAgreement()!=null && getMasterAgreement().hasData()) return true;
			if (getMasterConfirmation()!=null && getMasterConfirmation().hasData()) return true;
			if (getBrokerConfirmation()!=null && getBrokerConfirmation().hasData()) return true;
			if (getContractualDefinitions()!=null && getContractualDefinitions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContractualTermsSupplement()!=null && getContractualTermsSupplement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContractualMatrix()!=null && getContractualMatrix().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditSupportAgreement()!=null && getCreditSupportAgreement().hasData()) return true;
			if (getOtherAgreement()!=null && getOtherAgreement().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAttachment()!=null && getAttachment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Documentation.DocumentationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Documentation.DocumentationBuilder o = (Documentation.DocumentationBuilder) other;
			
			merger.mergeRosetta(getMasterAgreement(), o.getMasterAgreement(), this::setMasterAgreement);
			merger.mergeRosetta(getMasterConfirmation(), o.getMasterConfirmation(), this::setMasterConfirmation);
			merger.mergeRosetta(getBrokerConfirmation(), o.getBrokerConfirmation(), this::setBrokerConfirmation);
			merger.mergeRosetta(getContractualDefinitions(), o.getContractualDefinitions(), this::getOrCreateContractualDefinitions);
			merger.mergeRosetta(getContractualTermsSupplement(), o.getContractualTermsSupplement(), this::getOrCreateContractualTermsSupplement);
			merger.mergeRosetta(getContractualMatrix(), o.getContractualMatrix(), this::getOrCreateContractualMatrix);
			merger.mergeRosetta(getCreditSupportAgreement(), o.getCreditSupportAgreement(), this::setCreditSupportAgreement);
			merger.mergeRosetta(getOtherAgreement(), o.getOtherAgreement(), this::getOrCreateOtherAgreement);
			merger.mergeRosetta(getAttachment(), o.getAttachment(), this::getOrCreateAttachment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Documentation _that = getType().cast(o);
		
			if (!Objects.equals(masterAgreement, _that.getMasterAgreement())) return false;
			if (!Objects.equals(masterConfirmation, _that.getMasterConfirmation())) return false;
			if (!Objects.equals(brokerConfirmation, _that.getBrokerConfirmation())) return false;
			if (!ListEquals.listEquals(contractualDefinitions, _that.getContractualDefinitions())) return false;
			if (!ListEquals.listEquals(contractualTermsSupplement, _that.getContractualTermsSupplement())) return false;
			if (!ListEquals.listEquals(contractualMatrix, _that.getContractualMatrix())) return false;
			if (!Objects.equals(creditSupportAgreement, _that.getCreditSupportAgreement())) return false;
			if (!ListEquals.listEquals(otherAgreement, _that.getOtherAgreement())) return false;
			if (!ListEquals.listEquals(attachment, _that.getAttachment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterAgreement != null ? masterAgreement.hashCode() : 0);
			_result = 31 * _result + (masterConfirmation != null ? masterConfirmation.hashCode() : 0);
			_result = 31 * _result + (brokerConfirmation != null ? brokerConfirmation.hashCode() : 0);
			_result = 31 * _result + (contractualDefinitions != null ? contractualDefinitions.hashCode() : 0);
			_result = 31 * _result + (contractualTermsSupplement != null ? contractualTermsSupplement.hashCode() : 0);
			_result = 31 * _result + (contractualMatrix != null ? contractualMatrix.hashCode() : 0);
			_result = 31 * _result + (creditSupportAgreement != null ? creditSupportAgreement.hashCode() : 0);
			_result = 31 * _result + (otherAgreement != null ? otherAgreement.hashCode() : 0);
			_result = 31 * _result + (attachment != null ? attachment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentationBuilder {" +
				"masterAgreement=" + this.masterAgreement + ", " +
				"masterConfirmation=" + this.masterConfirmation + ", " +
				"brokerConfirmation=" + this.brokerConfirmation + ", " +
				"contractualDefinitions=" + this.contractualDefinitions + ", " +
				"contractualTermsSupplement=" + this.contractualTermsSupplement + ", " +
				"contractualMatrix=" + this.contractualMatrix + ", " +
				"creditSupportAgreement=" + this.creditSupportAgreement + ", " +
				"otherAgreement=" + this.otherAgreement + ", " +
				"attachment=" + this.attachment +
			'}';
		}
	}
}
