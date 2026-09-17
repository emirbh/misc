package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.common.ExecutionLocationEnum;
import cdm.legaldocumentation.csa.meta.ExecutionLocationMeta;
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
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify execution location terms of a Security Agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="ExecutionLocation", builder=ExecutionLocation.ExecutionLocationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ExecutionLocation", model="cdm", builder=ExecutionLocation.ExecutionLocationBuilderImpl.class, version="6.23.0")
public interface ExecutionLocation extends RosettaModelObject {

	ExecutionLocationMeta metaData = new ExecutionLocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The execution location of the agreement.
	 */
	ExecutionLocationEnum getExecutionLocation();
	/**
	 * Bespoke execution location language to be included when specified.
	 */
	String getOtherLanguage();
	/**
	 * The payer of documentary duty.
	 */
	String getDutyPayer();
	/**
	 * Bespoke terms specific to the payment of documentary duty.
	 */
	String getDutyPayerLanguage();
	/**
	 * The date that documentary duty will be paid.
	 */
	Date getDutyPaymentDate();
	/**
	 * Bespoke terms specific to the date that documentary duty will be paid.
	 */
	String getDutyPaymentLanguage();

	/*********************** Build Methods  ***********************/
	ExecutionLocation build();
	
	ExecutionLocation.ExecutionLocationBuilder toBuilder();
	
	static ExecutionLocation.ExecutionLocationBuilder builder() {
		return new ExecutionLocation.ExecutionLocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExecutionLocation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExecutionLocation> getType() {
		return ExecutionLocation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("executionLocation"), ExecutionLocationEnum.class, getExecutionLocation(), this);
		processor.processBasic(path.newSubPath("otherLanguage"), String.class, getOtherLanguage(), this);
		processor.processBasic(path.newSubPath("dutyPayer"), String.class, getDutyPayer(), this);
		processor.processBasic(path.newSubPath("dutyPayerLanguage"), String.class, getDutyPayerLanguage(), this);
		processor.processBasic(path.newSubPath("dutyPaymentDate"), Date.class, getDutyPaymentDate(), this);
		processor.processBasic(path.newSubPath("dutyPaymentLanguage"), String.class, getDutyPaymentLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExecutionLocationBuilder extends ExecutionLocation, RosettaModelObjectBuilder {
		ExecutionLocation.ExecutionLocationBuilder setExecutionLocation(ExecutionLocationEnum executionLocation);
		ExecutionLocation.ExecutionLocationBuilder setOtherLanguage(String otherLanguage);
		ExecutionLocation.ExecutionLocationBuilder setDutyPayer(String dutyPayer);
		ExecutionLocation.ExecutionLocationBuilder setDutyPayerLanguage(String dutyPayerLanguage);
		ExecutionLocation.ExecutionLocationBuilder setDutyPaymentDate(Date dutyPaymentDate);
		ExecutionLocation.ExecutionLocationBuilder setDutyPaymentLanguage(String dutyPaymentLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("executionLocation"), ExecutionLocationEnum.class, getExecutionLocation(), this);
			processor.processBasic(path.newSubPath("otherLanguage"), String.class, getOtherLanguage(), this);
			processor.processBasic(path.newSubPath("dutyPayer"), String.class, getDutyPayer(), this);
			processor.processBasic(path.newSubPath("dutyPayerLanguage"), String.class, getDutyPayerLanguage(), this);
			processor.processBasic(path.newSubPath("dutyPaymentDate"), Date.class, getDutyPaymentDate(), this);
			processor.processBasic(path.newSubPath("dutyPaymentLanguage"), String.class, getDutyPaymentLanguage(), this);
		}
		

		ExecutionLocation.ExecutionLocationBuilder prune();
	}

	/*********************** Immutable Implementation of ExecutionLocation  ***********************/
	class ExecutionLocationImpl implements ExecutionLocation {
		private final ExecutionLocationEnum executionLocation;
		private final String otherLanguage;
		private final String dutyPayer;
		private final String dutyPayerLanguage;
		private final Date dutyPaymentDate;
		private final String dutyPaymentLanguage;
		
		protected ExecutionLocationImpl(ExecutionLocation.ExecutionLocationBuilder builder) {
			this.executionLocation = builder.getExecutionLocation();
			this.otherLanguage = builder.getOtherLanguage();
			this.dutyPayer = builder.getDutyPayer();
			this.dutyPayerLanguage = builder.getDutyPayerLanguage();
			this.dutyPaymentDate = builder.getDutyPaymentDate();
			this.dutyPaymentLanguage = builder.getDutyPaymentLanguage();
		}
		
		@Override
		@RosettaAttribute("executionLocation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionLocation")
		public ExecutionLocationEnum getExecutionLocation() {
			return executionLocation;
		}
		
		@Override
		@RosettaAttribute("otherLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherLanguage")
		public String getOtherLanguage() {
			return otherLanguage;
		}
		
		@Override
		@RosettaAttribute("dutyPayer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dutyPayer")
		public String getDutyPayer() {
			return dutyPayer;
		}
		
		@Override
		@RosettaAttribute("dutyPayerLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dutyPayerLanguage")
		public String getDutyPayerLanguage() {
			return dutyPayerLanguage;
		}
		
		@Override
		@RosettaAttribute("dutyPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dutyPaymentDate")
		public Date getDutyPaymentDate() {
			return dutyPaymentDate;
		}
		
		@Override
		@RosettaAttribute("dutyPaymentLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dutyPaymentLanguage")
		public String getDutyPaymentLanguage() {
			return dutyPaymentLanguage;
		}
		
		@Override
		public ExecutionLocation build() {
			return this;
		}
		
		@Override
		public ExecutionLocation.ExecutionLocationBuilder toBuilder() {
			ExecutionLocation.ExecutionLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionLocation.ExecutionLocationBuilder builder) {
			ofNullable(getExecutionLocation()).ifPresent(builder::setExecutionLocation);
			ofNullable(getOtherLanguage()).ifPresent(builder::setOtherLanguage);
			ofNullable(getDutyPayer()).ifPresent(builder::setDutyPayer);
			ofNullable(getDutyPayerLanguage()).ifPresent(builder::setDutyPayerLanguage);
			ofNullable(getDutyPaymentDate()).ifPresent(builder::setDutyPaymentDate);
			ofNullable(getDutyPaymentLanguage()).ifPresent(builder::setDutyPaymentLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionLocation _that = getType().cast(o);
		
			if (!Objects.equals(executionLocation, _that.getExecutionLocation())) return false;
			if (!Objects.equals(otherLanguage, _that.getOtherLanguage())) return false;
			if (!Objects.equals(dutyPayer, _that.getDutyPayer())) return false;
			if (!Objects.equals(dutyPayerLanguage, _that.getDutyPayerLanguage())) return false;
			if (!Objects.equals(dutyPaymentDate, _that.getDutyPaymentDate())) return false;
			if (!Objects.equals(dutyPaymentLanguage, _that.getDutyPaymentLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionLocation != null ? executionLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLanguage != null ? otherLanguage.hashCode() : 0);
			_result = 31 * _result + (dutyPayer != null ? dutyPayer.hashCode() : 0);
			_result = 31 * _result + (dutyPayerLanguage != null ? dutyPayerLanguage.hashCode() : 0);
			_result = 31 * _result + (dutyPaymentDate != null ? dutyPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dutyPaymentLanguage != null ? dutyPaymentLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionLocation {" +
				"executionLocation=" + this.executionLocation + ", " +
				"otherLanguage=" + this.otherLanguage + ", " +
				"dutyPayer=" + this.dutyPayer + ", " +
				"dutyPayerLanguage=" + this.dutyPayerLanguage + ", " +
				"dutyPaymentDate=" + this.dutyPaymentDate + ", " +
				"dutyPaymentLanguage=" + this.dutyPaymentLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of ExecutionLocation  ***********************/
	class ExecutionLocationBuilderImpl implements ExecutionLocation.ExecutionLocationBuilder {
	
		protected ExecutionLocationEnum executionLocation;
		protected String otherLanguage;
		protected String dutyPayer;
		protected String dutyPayerLanguage;
		protected Date dutyPaymentDate;
		protected String dutyPaymentLanguage;
		
		@Override
		@RosettaAttribute("executionLocation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionLocation")
		public ExecutionLocationEnum getExecutionLocation() {
			return executionLocation;
		}
		
		@Override
		@RosettaAttribute("otherLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherLanguage")
		public String getOtherLanguage() {
			return otherLanguage;
		}
		
		@Override
		@RosettaAttribute("dutyPayer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dutyPayer")
		public String getDutyPayer() {
			return dutyPayer;
		}
		
		@Override
		@RosettaAttribute("dutyPayerLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dutyPayerLanguage")
		public String getDutyPayerLanguage() {
			return dutyPayerLanguage;
		}
		
		@Override
		@RosettaAttribute("dutyPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dutyPaymentDate")
		public Date getDutyPaymentDate() {
			return dutyPaymentDate;
		}
		
		@Override
		@RosettaAttribute("dutyPaymentLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dutyPaymentLanguage")
		public String getDutyPaymentLanguage() {
			return dutyPaymentLanguage;
		}
		
		@RosettaAttribute("executionLocation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionLocation")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setExecutionLocation(ExecutionLocationEnum _executionLocation) {
			this.executionLocation = _executionLocation == null ? null : _executionLocation;
			return this;
		}
		
		@RosettaAttribute("otherLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherLanguage")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setOtherLanguage(String _otherLanguage) {
			this.otherLanguage = _otherLanguage == null ? null : _otherLanguage;
			return this;
		}
		
		@RosettaAttribute("dutyPayer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dutyPayer")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setDutyPayer(String _dutyPayer) {
			this.dutyPayer = _dutyPayer == null ? null : _dutyPayer;
			return this;
		}
		
		@RosettaAttribute("dutyPayerLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dutyPayerLanguage")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setDutyPayerLanguage(String _dutyPayerLanguage) {
			this.dutyPayerLanguage = _dutyPayerLanguage == null ? null : _dutyPayerLanguage;
			return this;
		}
		
		@RosettaAttribute("dutyPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dutyPaymentDate")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setDutyPaymentDate(Date _dutyPaymentDate) {
			this.dutyPaymentDate = _dutyPaymentDate == null ? null : _dutyPaymentDate;
			return this;
		}
		
		@RosettaAttribute("dutyPaymentLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dutyPaymentLanguage")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder setDutyPaymentLanguage(String _dutyPaymentLanguage) {
			this.dutyPaymentLanguage = _dutyPaymentLanguage == null ? null : _dutyPaymentLanguage;
			return this;
		}
		
		@Override
		public ExecutionLocation build() {
			return new ExecutionLocation.ExecutionLocationImpl(this);
		}
		
		@Override
		public ExecutionLocation.ExecutionLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecutionLocation()!=null) return true;
			if (getOtherLanguage()!=null) return true;
			if (getDutyPayer()!=null) return true;
			if (getDutyPayerLanguage()!=null) return true;
			if (getDutyPaymentDate()!=null) return true;
			if (getDutyPaymentLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionLocation.ExecutionLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionLocation.ExecutionLocationBuilder o = (ExecutionLocation.ExecutionLocationBuilder) other;
			
			
			merger.mergeBasic(getExecutionLocation(), o.getExecutionLocation(), this::setExecutionLocation);
			merger.mergeBasic(getOtherLanguage(), o.getOtherLanguage(), this::setOtherLanguage);
			merger.mergeBasic(getDutyPayer(), o.getDutyPayer(), this::setDutyPayer);
			merger.mergeBasic(getDutyPayerLanguage(), o.getDutyPayerLanguage(), this::setDutyPayerLanguage);
			merger.mergeBasic(getDutyPaymentDate(), o.getDutyPaymentDate(), this::setDutyPaymentDate);
			merger.mergeBasic(getDutyPaymentLanguage(), o.getDutyPaymentLanguage(), this::setDutyPaymentLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionLocation _that = getType().cast(o);
		
			if (!Objects.equals(executionLocation, _that.getExecutionLocation())) return false;
			if (!Objects.equals(otherLanguage, _that.getOtherLanguage())) return false;
			if (!Objects.equals(dutyPayer, _that.getDutyPayer())) return false;
			if (!Objects.equals(dutyPayerLanguage, _that.getDutyPayerLanguage())) return false;
			if (!Objects.equals(dutyPaymentDate, _that.getDutyPaymentDate())) return false;
			if (!Objects.equals(dutyPaymentLanguage, _that.getDutyPaymentLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionLocation != null ? executionLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherLanguage != null ? otherLanguage.hashCode() : 0);
			_result = 31 * _result + (dutyPayer != null ? dutyPayer.hashCode() : 0);
			_result = 31 * _result + (dutyPayerLanguage != null ? dutyPayerLanguage.hashCode() : 0);
			_result = 31 * _result + (dutyPaymentDate != null ? dutyPaymentDate.hashCode() : 0);
			_result = 31 * _result + (dutyPaymentLanguage != null ? dutyPaymentLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionLocationBuilder {" +
				"executionLocation=" + this.executionLocation + ", " +
				"otherLanguage=" + this.otherLanguage + ", " +
				"dutyPayer=" + this.dutyPayer + ", " +
				"dutyPayerLanguage=" + this.dutyPayerLanguage + ", " +
				"dutyPaymentDate=" + this.dutyPaymentDate + ", " +
				"dutyPaymentLanguage=" + this.dutyPaymentLanguage +
			'}';
		}
	}
}
