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
import fpml.consolidated.doc.meta.SupervisorRegistrationMeta;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Provides information about a regulator or other supervisory body that an organization is registered with.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Provides information about a regulator or other supervisory body that an organization is registered with.
 *
 */
@RosettaDataType(value="SupervisorRegistration", builder=SupervisorRegistration.SupervisorRegistrationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SupervisorRegistration", model="fpml", builder=SupervisorRegistration.SupervisorRegistrationBuilderImpl.class, version="2.1.1")
public interface SupervisorRegistration extends RosettaModelObject {

	SupervisorRegistrationMeta metaData = new SupervisorRegistrationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The regulator or other supervisory body the organization is registered with (e.g. SEC).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The regulator or other supervisory body the organization is registered with (e.g. SEC).
	 *
	 */
	SupervisoryBody getSupervisoryBody();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ID assigned by the regulator (e.g. SEC's Central Index Key).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ID assigned by the regulator (e.g. SEC's Central Index Key).
	 *
	 */
	RegulatorId getRegistrationNumber();

	/*********************** Build Methods  ***********************/
	SupervisorRegistration build();
	
	SupervisorRegistration.SupervisorRegistrationBuilder toBuilder();
	
	static SupervisorRegistration.SupervisorRegistrationBuilder builder() {
		return new SupervisorRegistration.SupervisorRegistrationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SupervisorRegistration> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SupervisorRegistration> getType() {
		return SupervisorRegistration.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.class, getSupervisoryBody());
		processRosetta(path.newSubPath("registrationNumber"), processor, RegulatorId.class, getRegistrationNumber());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SupervisorRegistrationBuilder extends SupervisorRegistration, RosettaModelObjectBuilder {
		SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody();
		@Override
		SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody();
		RegulatorId.RegulatorIdBuilder getOrCreateRegistrationNumber();
		@Override
		RegulatorId.RegulatorIdBuilder getRegistrationNumber();
		SupervisorRegistration.SupervisorRegistrationBuilder setSupervisoryBody(SupervisoryBody supervisoryBody);
		SupervisorRegistration.SupervisorRegistrationBuilder setRegistrationNumber(RegulatorId registrationNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.SupervisoryBodyBuilder.class, getSupervisoryBody());
			processRosetta(path.newSubPath("registrationNumber"), processor, RegulatorId.RegulatorIdBuilder.class, getRegistrationNumber());
		}
		

		SupervisorRegistration.SupervisorRegistrationBuilder prune();
	}

	/*********************** Immutable Implementation of SupervisorRegistration  ***********************/
	class SupervisorRegistrationImpl implements SupervisorRegistration {
		private final SupervisoryBody supervisoryBody;
		private final RegulatorId registrationNumber;
		
		protected SupervisorRegistrationImpl(SupervisorRegistration.SupervisorRegistrationBuilder builder) {
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).map(f->f.build()).orElse(null);
			this.registrationNumber = ofNullable(builder.getRegistrationNumber()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		public SupervisoryBody getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("registrationNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("registrationNumber")
		public RegulatorId getRegistrationNumber() {
			return registrationNumber;
		}
		
		@Override
		public SupervisorRegistration build() {
			return this;
		}
		
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder toBuilder() {
			SupervisorRegistration.SupervisorRegistrationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SupervisorRegistration.SupervisorRegistrationBuilder builder) {
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getRegistrationNumber()).ifPresent(builder::setRegistrationNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupervisorRegistration _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(registrationNumber, _that.getRegistrationNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupervisorRegistration {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"registrationNumber=" + this.registrationNumber +
			'}';
		}
	}

	/*********************** Builder Implementation of SupervisorRegistration  ***********************/
	class SupervisorRegistrationBuilderImpl implements SupervisorRegistration.SupervisorRegistrationBuilder {
	
		protected SupervisoryBody.SupervisoryBodyBuilder supervisoryBody;
		protected RegulatorId.RegulatorIdBuilder registrationNumber;
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		public SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody() {
			SupervisoryBody.SupervisoryBodyBuilder result;
			if (supervisoryBody!=null) {
				result = supervisoryBody;
			}
			else {
				result = supervisoryBody = SupervisoryBody.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("registrationNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("registrationNumber")
		public RegulatorId.RegulatorIdBuilder getRegistrationNumber() {
			return registrationNumber;
		}
		
		@Override
		public RegulatorId.RegulatorIdBuilder getOrCreateRegistrationNumber() {
			RegulatorId.RegulatorIdBuilder result;
			if (registrationNumber!=null) {
				result = registrationNumber;
			}
			else {
				result = registrationNumber = RegulatorId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder setSupervisoryBody(SupervisoryBody _supervisoryBody) {
			this.supervisoryBody = _supervisoryBody == null ? null : _supervisoryBody.toBuilder();
			return this;
		}
		
		@RosettaAttribute("registrationNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("registrationNumber")
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder setRegistrationNumber(RegulatorId _registrationNumber) {
			this.registrationNumber = _registrationNumber == null ? null : _registrationNumber.toBuilder();
			return this;
		}
		
		@Override
		public SupervisorRegistration build() {
			return new SupervisorRegistration.SupervisorRegistrationImpl(this);
		}
		
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder prune() {
			if (supervisoryBody!=null && !supervisoryBody.prune().hasData()) supervisoryBody = null;
			if (registrationNumber!=null && !registrationNumber.prune().hasData()) registrationNumber = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSupervisoryBody()!=null && getSupervisoryBody().hasData()) return true;
			if (getRegistrationNumber()!=null && getRegistrationNumber().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SupervisorRegistration.SupervisorRegistrationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SupervisorRegistration.SupervisorRegistrationBuilder o = (SupervisorRegistration.SupervisorRegistrationBuilder) other;
			
			merger.mergeRosetta(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			merger.mergeRosetta(getRegistrationNumber(), o.getRegistrationNumber(), this::setRegistrationNumber);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SupervisorRegistration _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(registrationNumber, _that.getRegistrationNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SupervisorRegistrationBuilder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"registrationNumber=" + this.registrationNumber +
			'}';
		}
	}
}
