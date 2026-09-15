package drr.regulation.common;

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
import drr.regulation.common.meta.ClearingExceptionDeclarationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies supporting evidence when claiming an end user exception.
 * @version 7.7.0
 */
@RosettaDataType(value="ClearingExceptionDeclaration", builder=ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ClearingExceptionDeclaration", model="drr", builder=ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilderImpl.class, version="7.7.0")
public interface ClearingExceptionDeclaration extends RosettaModelObject {

	ClearingExceptionDeclarationMeta metaData = new ClearingExceptionDeclarationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies arrangements being made to provide credit.
	 */
	List<CreditDocumentEnum> getCreditDocument();
	/**
	 * Specifies the categories or characteristics that apply to an organization which allow it to apply for an end-user exception determination.
	 */
	List<OrganizationCharacteristicEnum> getOrganizationCharacteristic();
	/**
	 * Specifies the categories or characteristics that apply to a transaction which allow application of an end-user exception determination.
	 */
	List<TransactionCharacteristicEnum> getTransactionCharacteristic();

	/*********************** Build Methods  ***********************/
	ClearingExceptionDeclaration build();
	
	ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder toBuilder();
	
	static ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder builder() {
		return new ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingExceptionDeclaration> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingExceptionDeclaration> getType() {
		return ClearingExceptionDeclaration.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("creditDocument"), CreditDocumentEnum.class, getCreditDocument(), this);
		processor.processBasic(path.newSubPath("organizationCharacteristic"), OrganizationCharacteristicEnum.class, getOrganizationCharacteristic(), this);
		processor.processBasic(path.newSubPath("transactionCharacteristic"), TransactionCharacteristicEnum.class, getTransactionCharacteristic(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingExceptionDeclarationBuilder extends ClearingExceptionDeclaration, RosettaModelObjectBuilder {
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addCreditDocument(CreditDocumentEnum creditDocument);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addCreditDocument(CreditDocumentEnum creditDocument, int idx);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addCreditDocument(List<CreditDocumentEnum> creditDocument);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder setCreditDocument(List<CreditDocumentEnum> creditDocument);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristicEnum organizationCharacteristic);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristicEnum organizationCharacteristic, int idx);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addOrganizationCharacteristic(List<OrganizationCharacteristicEnum> organizationCharacteristic);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder setOrganizationCharacteristic(List<OrganizationCharacteristicEnum> organizationCharacteristic);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristicEnum transactionCharacteristic);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristicEnum transactionCharacteristic, int idx);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addTransactionCharacteristic(List<TransactionCharacteristicEnum> transactionCharacteristic);
		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder setTransactionCharacteristic(List<TransactionCharacteristicEnum> transactionCharacteristic);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("creditDocument"), CreditDocumentEnum.class, getCreditDocument(), this);
			processor.processBasic(path.newSubPath("organizationCharacteristic"), OrganizationCharacteristicEnum.class, getOrganizationCharacteristic(), this);
			processor.processBasic(path.newSubPath("transactionCharacteristic"), TransactionCharacteristicEnum.class, getTransactionCharacteristic(), this);
		}
		

		ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingExceptionDeclaration  ***********************/
	class ClearingExceptionDeclarationImpl implements ClearingExceptionDeclaration {
		private final List<CreditDocumentEnum> creditDocument;
		private final List<OrganizationCharacteristicEnum> organizationCharacteristic;
		private final List<TransactionCharacteristicEnum> transactionCharacteristic;
		
		protected ClearingExceptionDeclarationImpl(ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder builder) {
			this.creditDocument = ofNullable(builder.getCreditDocument()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.organizationCharacteristic = ofNullable(builder.getOrganizationCharacteristic()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.transactionCharacteristic = ofNullable(builder.getTransactionCharacteristic()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditDocument")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditDocument")
		public List<CreditDocumentEnum> getCreditDocument() {
			return creditDocument;
		}
		
		@Override
		@RosettaAttribute("organizationCharacteristic")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("organizationCharacteristic")
		public List<OrganizationCharacteristicEnum> getOrganizationCharacteristic() {
			return organizationCharacteristic;
		}
		
		@Override
		@RosettaAttribute("transactionCharacteristic")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transactionCharacteristic")
		public List<TransactionCharacteristicEnum> getTransactionCharacteristic() {
			return transactionCharacteristic;
		}
		
		@Override
		public ClearingExceptionDeclaration build() {
			return this;
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder toBuilder() {
			ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder builder) {
			ofNullable(getCreditDocument()).ifPresent(builder::setCreditDocument);
			ofNullable(getOrganizationCharacteristic()).ifPresent(builder::setOrganizationCharacteristic);
			ofNullable(getTransactionCharacteristic()).ifPresent(builder::setTransactionCharacteristic);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingExceptionDeclaration _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditDocument, _that.getCreditDocument())) return false;
			if (!ListEquals.listEquals(organizationCharacteristic, _that.getOrganizationCharacteristic())) return false;
			if (!ListEquals.listEquals(transactionCharacteristic, _that.getTransactionCharacteristic())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditDocument != null ? creditDocument.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (organizationCharacteristic != null ? organizationCharacteristic.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (transactionCharacteristic != null ? transactionCharacteristic.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingExceptionDeclaration {" +
				"creditDocument=" + this.creditDocument + ", " +
				"organizationCharacteristic=" + this.organizationCharacteristic + ", " +
				"transactionCharacteristic=" + this.transactionCharacteristic +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingExceptionDeclaration  ***********************/
	class ClearingExceptionDeclarationBuilderImpl implements ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder {
	
		protected List<CreditDocumentEnum> creditDocument = new ArrayList<>();
		protected List<OrganizationCharacteristicEnum> organizationCharacteristic = new ArrayList<>();
		protected List<TransactionCharacteristicEnum> transactionCharacteristic = new ArrayList<>();
		
		@Override
		@RosettaAttribute("creditDocument")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditDocument")
		public List<CreditDocumentEnum> getCreditDocument() {
			return creditDocument;
		}
		
		@Override
		@RosettaAttribute("organizationCharacteristic")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("organizationCharacteristic")
		public List<OrganizationCharacteristicEnum> getOrganizationCharacteristic() {
			return organizationCharacteristic;
		}
		
		@Override
		@RosettaAttribute("transactionCharacteristic")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transactionCharacteristic")
		public List<TransactionCharacteristicEnum> getTransactionCharacteristic() {
			return transactionCharacteristic;
		}
		
		@RosettaAttribute("creditDocument")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditDocument")
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addCreditDocument(CreditDocumentEnum _creditDocument) {
			if (_creditDocument != null) {
				this.creditDocument.add(_creditDocument);
			}
			return this;
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addCreditDocument(CreditDocumentEnum _creditDocument, int idx) {
			getIndex(this.creditDocument, idx, () -> _creditDocument);
			return this;
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addCreditDocument(List<CreditDocumentEnum> creditDocuments) {
			if (creditDocuments != null) {
				for (final CreditDocumentEnum toAdd : creditDocuments) {
					this.creditDocument.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditDocument")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditDocument")
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder setCreditDocument(List<CreditDocumentEnum> creditDocuments) {
			if (creditDocuments == null) {
				this.creditDocument = new ArrayList<>();
			} else {
				this.creditDocument = creditDocuments.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("organizationCharacteristic")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("organizationCharacteristic")
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristicEnum _organizationCharacteristic) {
			if (_organizationCharacteristic != null) {
				this.organizationCharacteristic.add(_organizationCharacteristic);
			}
			return this;
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristicEnum _organizationCharacteristic, int idx) {
			getIndex(this.organizationCharacteristic, idx, () -> _organizationCharacteristic);
			return this;
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addOrganizationCharacteristic(List<OrganizationCharacteristicEnum> organizationCharacteristics) {
			if (organizationCharacteristics != null) {
				for (final OrganizationCharacteristicEnum toAdd : organizationCharacteristics) {
					this.organizationCharacteristic.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("organizationCharacteristic")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("organizationCharacteristic")
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder setOrganizationCharacteristic(List<OrganizationCharacteristicEnum> organizationCharacteristics) {
			if (organizationCharacteristics == null) {
				this.organizationCharacteristic = new ArrayList<>();
			} else {
				this.organizationCharacteristic = organizationCharacteristics.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("transactionCharacteristic")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("transactionCharacteristic")
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristicEnum _transactionCharacteristic) {
			if (_transactionCharacteristic != null) {
				this.transactionCharacteristic.add(_transactionCharacteristic);
			}
			return this;
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristicEnum _transactionCharacteristic, int idx) {
			getIndex(this.transactionCharacteristic, idx, () -> _transactionCharacteristic);
			return this;
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder addTransactionCharacteristic(List<TransactionCharacteristicEnum> transactionCharacteristics) {
			if (transactionCharacteristics != null) {
				for (final TransactionCharacteristicEnum toAdd : transactionCharacteristics) {
					this.transactionCharacteristic.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("transactionCharacteristic")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("transactionCharacteristic")
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder setTransactionCharacteristic(List<TransactionCharacteristicEnum> transactionCharacteristics) {
			if (transactionCharacteristics == null) {
				this.transactionCharacteristic = new ArrayList<>();
			} else {
				this.transactionCharacteristic = transactionCharacteristics.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ClearingExceptionDeclaration build() {
			return new ClearingExceptionDeclaration.ClearingExceptionDeclarationImpl(this);
		}
		
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditDocument()!=null && !getCreditDocument().isEmpty()) return true;
			if (getOrganizationCharacteristic()!=null && !getOrganizationCharacteristic().isEmpty()) return true;
			if (getTransactionCharacteristic()!=null && !getTransactionCharacteristic().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder o = (ClearingExceptionDeclaration.ClearingExceptionDeclarationBuilder) other;
			
			
			merger.mergeBasic(getCreditDocument(), o.getCreditDocument(), (Consumer<CreditDocumentEnum>) this::addCreditDocument);
			merger.mergeBasic(getOrganizationCharacteristic(), o.getOrganizationCharacteristic(), (Consumer<OrganizationCharacteristicEnum>) this::addOrganizationCharacteristic);
			merger.mergeBasic(getTransactionCharacteristic(), o.getTransactionCharacteristic(), (Consumer<TransactionCharacteristicEnum>) this::addTransactionCharacteristic);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingExceptionDeclaration _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditDocument, _that.getCreditDocument())) return false;
			if (!ListEquals.listEquals(organizationCharacteristic, _that.getOrganizationCharacteristic())) return false;
			if (!ListEquals.listEquals(transactionCharacteristic, _that.getTransactionCharacteristic())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditDocument != null ? creditDocument.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (organizationCharacteristic != null ? organizationCharacteristic.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (transactionCharacteristic != null ? transactionCharacteristic.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingExceptionDeclarationBuilder {" +
				"creditDocument=" + this.creditDocument + ", " +
				"organizationCharacteristic=" + this.organizationCharacteristic + ", " +
				"transactionCharacteristic=" + this.transactionCharacteristic +
			'}';
		}
	}
}
