package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.FacilityExecutionExceptionDeclarationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Provides supporting evidence when a party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Provides supporting evidence when a party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
 *
 */
@RosettaDataType(value="FacilityExecutionExceptionDeclaration", builder=FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilityExecutionExceptionDeclaration", model="fpml", builder=FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilderImpl.class, version="2.1.1")
public interface FacilityExecutionExceptionDeclaration extends RosettaModelObject {

	FacilityExecutionExceptionDeclarationMeta metaData = new FacilityExecutionExceptionDeclarationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reason for not executing the trade on SEF or other facility.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reason for not executing the trade on SEF or other facility.
	 *
	 */
	List<String> getReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the organization to specify which categories or characteristics apply to it for end-user exception determination. Examples include "FinancialEntity", "CaptiveFinanceUnit", "BoardOfDirectorsApproval".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the organization to specify which categories or characteristics apply to it for end-user exception determination. Examples include "FinancialEntity", "CaptiveFinanceUnit", "BoardOfDirectorsApproval".
	 *
	 */
	List<? extends OrganizationCharacteristic> getOrganizationCharacteristic();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the relevant transaction level categories or characteristics to be recorded for end-user exception determination. Examples include "BoardOfDirectorsApproval", "HedgesCommercialRisk".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the relevant transaction level categories or characteristics to be recorded for end-user exception determination. Examples include "BoardOfDirectorsApproval", "HedgesCommercialRisk".
	 *
	 */
	List<? extends TransactionCharacteristic> getTransactionCharacteristic();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the organization to specify which if any relevant regulators it is registered with, and if so their identification number. For example, it could specify that it is SEC registered and provide its Central Index Key.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the organization to specify which if any relevant regulators it is registered with, and if so their identification number. For example, it could specify that it is SEC registered and provide its Central Index Key.
	 *
	 */
	List<? extends SupervisorRegistration> getSupervisorRegistration();

	/*********************** Build Methods  ***********************/
	FacilityExecutionExceptionDeclaration build();
	
	FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder toBuilder();
	
	static FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder builder() {
		return new FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityExecutionExceptionDeclaration> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilityExecutionExceptionDeclaration> getType() {
		return FacilityExecutionExceptionDeclaration.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("reason"), String.class, getReason(), this);
		processRosetta(path.newSubPath("organizationCharacteristic"), processor, OrganizationCharacteristic.class, getOrganizationCharacteristic());
		processRosetta(path.newSubPath("transactionCharacteristic"), processor, TransactionCharacteristic.class, getTransactionCharacteristic());
		processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.class, getSupervisorRegistration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityExecutionExceptionDeclarationBuilder extends FacilityExecutionExceptionDeclaration, RosettaModelObjectBuilder {
		OrganizationCharacteristic.OrganizationCharacteristicBuilder getOrCreateOrganizationCharacteristic(int index);
		@Override
		List<? extends OrganizationCharacteristic.OrganizationCharacteristicBuilder> getOrganizationCharacteristic();
		TransactionCharacteristic.TransactionCharacteristicBuilder getOrCreateTransactionCharacteristic(int index);
		@Override
		List<? extends TransactionCharacteristic.TransactionCharacteristicBuilder> getTransactionCharacteristic();
		SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int index);
		@Override
		List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration();
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(String reason);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(String reason, int idx);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(List<String> reason);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setReason(List<String> reason);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic organizationCharacteristic, int idx);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristic);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristic);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic transactionCharacteristic, int idx);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristic);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristic);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration supervisorRegistration, int idx);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration);
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistration);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("reason"), String.class, getReason(), this);
			processRosetta(path.newSubPath("organizationCharacteristic"), processor, OrganizationCharacteristic.OrganizationCharacteristicBuilder.class, getOrganizationCharacteristic());
			processRosetta(path.newSubPath("transactionCharacteristic"), processor, TransactionCharacteristic.TransactionCharacteristicBuilder.class, getTransactionCharacteristic());
			processRosetta(path.newSubPath("supervisorRegistration"), processor, SupervisorRegistration.SupervisorRegistrationBuilder.class, getSupervisorRegistration());
		}
		

		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityExecutionExceptionDeclaration  ***********************/
	class FacilityExecutionExceptionDeclarationImpl implements FacilityExecutionExceptionDeclaration {
		private final List<String> reason;
		private final List<? extends OrganizationCharacteristic> organizationCharacteristic;
		private final List<? extends TransactionCharacteristic> transactionCharacteristic;
		private final List<? extends SupervisorRegistration> supervisorRegistration;
		
		protected FacilityExecutionExceptionDeclarationImpl(FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder builder) {
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.organizationCharacteristic = ofNullable(builder.getOrganizationCharacteristic()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transactionCharacteristic = ofNullable(builder.getTransactionCharacteristic()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.supervisorRegistration = ofNullable(builder.getSupervisorRegistration()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<String> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("organizationCharacteristic")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("organizationCharacteristic")
		public List<? extends OrganizationCharacteristic> getOrganizationCharacteristic() {
			return organizationCharacteristic;
		}
		
		@Override
		@RosettaAttribute("transactionCharacteristic")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transactionCharacteristic")
		public List<? extends TransactionCharacteristic> getTransactionCharacteristic() {
			return transactionCharacteristic;
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration build() {
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder toBuilder() {
			FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder builder) {
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getOrganizationCharacteristic()).ifPresent(builder::setOrganizationCharacteristic);
			ofNullable(getTransactionCharacteristic()).ifPresent(builder::setTransactionCharacteristic);
			ofNullable(getSupervisorRegistration()).ifPresent(builder::setSupervisorRegistration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityExecutionExceptionDeclaration _that = getType().cast(o);
		
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(organizationCharacteristic, _that.getOrganizationCharacteristic())) return false;
			if (!ListEquals.listEquals(transactionCharacteristic, _that.getTransactionCharacteristic())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (organizationCharacteristic != null ? organizationCharacteristic.hashCode() : 0);
			_result = 31 * _result + (transactionCharacteristic != null ? transactionCharacteristic.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityExecutionExceptionDeclaration {" +
				"reason=" + this.reason + ", " +
				"organizationCharacteristic=" + this.organizationCharacteristic + ", " +
				"transactionCharacteristic=" + this.transactionCharacteristic + ", " +
				"supervisorRegistration=" + this.supervisorRegistration +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityExecutionExceptionDeclaration  ***********************/
	class FacilityExecutionExceptionDeclarationBuilderImpl implements FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder {
	
		protected List<String> reason = new ArrayList<>();
		protected List<OrganizationCharacteristic.OrganizationCharacteristicBuilder> organizationCharacteristic = new ArrayList<>();
		protected List<TransactionCharacteristic.TransactionCharacteristicBuilder> transactionCharacteristic = new ArrayList<>();
		protected List<SupervisorRegistration.SupervisorRegistrationBuilder> supervisorRegistration = new ArrayList<>();
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<String> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("organizationCharacteristic")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("organizationCharacteristic")
		public List<? extends OrganizationCharacteristic.OrganizationCharacteristicBuilder> getOrganizationCharacteristic() {
			return organizationCharacteristic;
		}
		
		@Override
		public OrganizationCharacteristic.OrganizationCharacteristicBuilder getOrCreateOrganizationCharacteristic(int index) {
			if (organizationCharacteristic==null) {
				this.organizationCharacteristic = new ArrayList<>();
			}
			return getIndex(organizationCharacteristic, index, () -> {
						OrganizationCharacteristic.OrganizationCharacteristicBuilder newOrganizationCharacteristic = OrganizationCharacteristic.builder();
						return newOrganizationCharacteristic;
					});
		}
		
		@Override
		@RosettaAttribute("transactionCharacteristic")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transactionCharacteristic")
		public List<? extends TransactionCharacteristic.TransactionCharacteristicBuilder> getTransactionCharacteristic() {
			return transactionCharacteristic;
		}
		
		@Override
		public TransactionCharacteristic.TransactionCharacteristicBuilder getOrCreateTransactionCharacteristic(int index) {
			if (transactionCharacteristic==null) {
				this.transactionCharacteristic = new ArrayList<>();
			}
			return getIndex(transactionCharacteristic, index, () -> {
						TransactionCharacteristic.TransactionCharacteristicBuilder newTransactionCharacteristic = TransactionCharacteristic.builder();
						return newTransactionCharacteristic;
					});
		}
		
		@Override
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		public List<? extends SupervisorRegistration.SupervisorRegistrationBuilder> getSupervisorRegistration() {
			return supervisorRegistration;
		}
		
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder getOrCreateSupervisorRegistration(int index) {
			if (supervisorRegistration==null) {
				this.supervisorRegistration = new ArrayList<>();
			}
			return getIndex(supervisorRegistration, index, () -> {
						SupervisorRegistration.SupervisorRegistrationBuilder newSupervisorRegistration = SupervisorRegistration.builder();
						return newSupervisorRegistration;
					});
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(String _reason) {
			if (_reason != null) {
				this.reason.add(_reason);
			}
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(String _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason);
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addReason(List<String> reasons) {
			if (reasons != null) {
				for (final String toAdd : reasons) {
					this.reason.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setReason(List<String> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("organizationCharacteristic")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("organizationCharacteristic")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic _organizationCharacteristic) {
			if (_organizationCharacteristic != null) {
				this.organizationCharacteristic.add(_organizationCharacteristic.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(OrganizationCharacteristic _organizationCharacteristic, int idx) {
			getIndex(this.organizationCharacteristic, idx, () -> _organizationCharacteristic.toBuilder());
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristics) {
			if (organizationCharacteristics != null) {
				for (final OrganizationCharacteristic toAdd : organizationCharacteristics) {
					this.organizationCharacteristic.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("organizationCharacteristic")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("organizationCharacteristic")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setOrganizationCharacteristic(List<? extends OrganizationCharacteristic> organizationCharacteristics) {
			if (organizationCharacteristics == null) {
				this.organizationCharacteristic = new ArrayList<>();
			} else {
				this.organizationCharacteristic = organizationCharacteristics.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("transactionCharacteristic")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("transactionCharacteristic")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic _transactionCharacteristic) {
			if (_transactionCharacteristic != null) {
				this.transactionCharacteristic.add(_transactionCharacteristic.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(TransactionCharacteristic _transactionCharacteristic, int idx) {
			getIndex(this.transactionCharacteristic, idx, () -> _transactionCharacteristic.toBuilder());
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristics) {
			if (transactionCharacteristics != null) {
				for (final TransactionCharacteristic toAdd : transactionCharacteristics) {
					this.transactionCharacteristic.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("transactionCharacteristic")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("transactionCharacteristic")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setTransactionCharacteristic(List<? extends TransactionCharacteristic> transactionCharacteristics) {
			if (transactionCharacteristics == null) {
				this.transactionCharacteristic = new ArrayList<>();
			} else {
				this.transactionCharacteristic = transactionCharacteristics.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration _supervisorRegistration) {
			if (_supervisorRegistration != null) {
				this.supervisorRegistration.add(_supervisorRegistration.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(SupervisorRegistration _supervisorRegistration, int idx) {
			getIndex(this.supervisorRegistration, idx, () -> _supervisorRegistration.toBuilder());
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder addSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations != null) {
				for (final SupervisorRegistration toAdd : supervisorRegistrations) {
					this.supervisorRegistration.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("supervisorRegistration")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("supervisorRegistration")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder setSupervisorRegistration(List<? extends SupervisorRegistration> supervisorRegistrations) {
			if (supervisorRegistrations == null) {
				this.supervisorRegistration = new ArrayList<>();
			} else {
				this.supervisorRegistration = supervisorRegistrations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration build() {
			return new FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationImpl(this);
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder prune() {
			organizationCharacteristic = organizationCharacteristic.stream().filter(b->b!=null).<OrganizationCharacteristic.OrganizationCharacteristicBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			transactionCharacteristic = transactionCharacteristic.stream().filter(b->b!=null).<TransactionCharacteristic.TransactionCharacteristicBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			supervisorRegistration = supervisorRegistration.stream().filter(b->b!=null).<SupervisorRegistration.SupervisorRegistrationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReason()!=null && !getReason().isEmpty()) return true;
			if (getOrganizationCharacteristic()!=null && getOrganizationCharacteristic().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransactionCharacteristic()!=null && getTransactionCharacteristic().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSupervisorRegistration()!=null && getSupervisorRegistration().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder o = (FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder) other;
			
			merger.mergeRosetta(getOrganizationCharacteristic(), o.getOrganizationCharacteristic(), this::getOrCreateOrganizationCharacteristic);
			merger.mergeRosetta(getTransactionCharacteristic(), o.getTransactionCharacteristic(), this::getOrCreateTransactionCharacteristic);
			merger.mergeRosetta(getSupervisorRegistration(), o.getSupervisorRegistration(), this::getOrCreateSupervisorRegistration);
			
			merger.mergeBasic(getReason(), o.getReason(), (Consumer<String>) this::addReason);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityExecutionExceptionDeclaration _that = getType().cast(o);
		
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(organizationCharacteristic, _that.getOrganizationCharacteristic())) return false;
			if (!ListEquals.listEquals(transactionCharacteristic, _that.getTransactionCharacteristic())) return false;
			if (!ListEquals.listEquals(supervisorRegistration, _that.getSupervisorRegistration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (organizationCharacteristic != null ? organizationCharacteristic.hashCode() : 0);
			_result = 31 * _result + (transactionCharacteristic != null ? transactionCharacteristic.hashCode() : 0);
			_result = 31 * _result + (supervisorRegistration != null ? supervisorRegistration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityExecutionExceptionDeclarationBuilder {" +
				"reason=" + this.reason + ", " +
				"organizationCharacteristic=" + this.organizationCharacteristic + ", " +
				"transactionCharacteristic=" + this.transactionCharacteristic + ", " +
				"supervisorRegistration=" + this.supervisorRegistration +
			'}';
		}
	}
}
