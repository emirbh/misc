package drr.regulation.common;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.base.margin.CollateralDetails;
import drr.base.margin.CollateralReportInstructionBase;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.ReportingSide;
import drr.regulation.common.meta.CollateralReportInstructionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies a reportable collateral with with a single reporting side.
 * @version 7.7.0
 */
@RosettaDataType(value="CollateralReportInstruction", builder=CollateralReportInstruction.CollateralReportInstructionBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CollateralReportInstruction", model="drr", builder=CollateralReportInstruction.CollateralReportInstructionBuilderImpl.class, version="7.7.0")
public interface CollateralReportInstruction extends CollateralReportInstructionBase {

	CollateralReportInstructionMeta metaData = new CollateralReportInstructionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Additional information required for a reportable transaction, including the reporting regime.
	 */
	@Override
	ReportableInformation getReportableInformation();

	/*********************** Build Methods  ***********************/
	CollateralReportInstruction build();
	
	CollateralReportInstruction.CollateralReportInstructionBuilder toBuilder();
	
	static CollateralReportInstruction.CollateralReportInstructionBuilder builder() {
		return new CollateralReportInstruction.CollateralReportInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralReportInstruction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralReportInstruction> getType() {
		return CollateralReportInstruction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.class, getCollateralDetails());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.class, getReportableInformation());
		processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.class, getReportingSide());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralReportInstructionBuilder extends CollateralReportInstruction, CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder {
		ReportableInformation.ReportableInformationBuilder getOrCreateReportableInformation();
		@Override
		ReportableInformation.ReportableInformationBuilder getReportableInformation();
		@Override
		CollateralReportInstruction.CollateralReportInstructionBuilder setCollateralDetails(CollateralDetails collateralDetails);
		@Override
		CollateralReportInstruction.CollateralReportInstructionBuilder setReportableInformation(ReportableInformationBase reportableInformation);
		@Override
		CollateralReportInstruction.CollateralReportInstructionBuilder setReportingSide(ReportingSide reportingSide);
		CollateralReportInstruction.CollateralReportInstructionBuilder setReportableInformation(ReportableInformation reportableInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.CollateralDetailsBuilder.class, getCollateralDetails());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.ReportableInformationBuilder.class, getReportableInformation());
			processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.ReportingSideBuilder.class, getReportingSide());
		}
		

		CollateralReportInstruction.CollateralReportInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralReportInstruction  ***********************/
	class CollateralReportInstructionImpl extends CollateralReportInstructionBase.CollateralReportInstructionBaseImpl implements CollateralReportInstruction {
		private final ReportableInformation reportableInformation;
		
		protected CollateralReportInstructionImpl(CollateralReportInstruction.CollateralReportInstructionBuilder builder) {
			super(builder);
			this.reportableInformation = ofNullable(builder.getReportableInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableInformation")
		public ReportableInformation getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public CollateralReportInstruction build() {
			return this;
		}
		
		@Override
		public CollateralReportInstruction.CollateralReportInstructionBuilder toBuilder() {
			CollateralReportInstruction.CollateralReportInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralReportInstruction.CollateralReportInstructionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportableInformation()).ifPresent(builder::setReportableInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralReportInstruction _that = getType().cast(o);
		
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralReportInstruction {" +
				"reportableInformation=" + this.reportableInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralReportInstruction  ***********************/
	class CollateralReportInstructionBuilderImpl implements CollateralReportInstruction.CollateralReportInstructionBuilder {
	
		protected CollateralDetails.CollateralDetailsBuilder collateralDetails;
		protected ReportableInformation.ReportableInformationBuilder reportableInformation;
		protected ReportingSide.ReportingSideBuilder reportingSide;
		
		@Override
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralDetails")
		public CollateralDetails.CollateralDetailsBuilder getCollateralDetails() {
			return collateralDetails;
		}
		
		@Override
		public CollateralDetails.CollateralDetailsBuilder getOrCreateCollateralDetails() {
			CollateralDetails.CollateralDetailsBuilder result;
			if (collateralDetails!=null) {
				result = collateralDetails;
			}
			else {
				result = collateralDetails = CollateralDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableInformation")
		public ReportableInformation.ReportableInformationBuilder getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder getOrCreateReportableInformation() {
			ReportableInformation.ReportableInformationBuilder result;
			if (reportableInformation!=null) {
				result = reportableInformation;
			}
			else {
				result = reportableInformation = ReportableInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingSide")
		public ReportingSide.ReportingSideBuilder getReportingSide() {
			return reportingSide;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder getOrCreateReportingSide() {
			ReportingSide.ReportingSideBuilder result;
			if (reportingSide!=null) {
				result = reportingSide;
			}
			else {
				result = reportingSide = ReportingSide.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralDetails")
		@Override
		public CollateralReportInstruction.CollateralReportInstructionBuilder setCollateralDetails(CollateralDetails _collateralDetails) {
			this.collateralDetails = _collateralDetails == null ? null : _collateralDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public CollateralReportInstruction.CollateralReportInstructionBuilder setReportableInformation(ReportableInformation _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CollateralReportInstruction.CollateralReportInstructionBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			final ReportableInformation ifThenElseResult;
			if (_reportableInformation == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _reportableInformation instanceof ReportableInformation ? ReportableInformation.class.cast(_reportableInformation) : null;
			}
			return setReportableInformation(ifThenElseResult);
		}
		
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingSide")
		@Override
		public CollateralReportInstruction.CollateralReportInstructionBuilder setReportingSide(ReportingSide _reportingSide) {
			this.reportingSide = _reportingSide == null ? null : _reportingSide.toBuilder();
			return this;
		}
		
		@Override
		public CollateralReportInstruction build() {
			return new CollateralReportInstruction.CollateralReportInstructionImpl(this);
		}
		
		@Override
		public CollateralReportInstruction.CollateralReportInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralReportInstruction.CollateralReportInstructionBuilder prune() {
			if (collateralDetails!=null && !collateralDetails.prune().hasData()) collateralDetails = null;
			if (reportableInformation!=null && !reportableInformation.prune().hasData()) reportableInformation = null;
			if (reportingSide!=null && !reportingSide.prune().hasData()) reportingSide = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralDetails()!=null && getCollateralDetails().hasData()) return true;
			if (getReportableInformation()!=null && getReportableInformation().hasData()) return true;
			if (getReportingSide()!=null && getReportingSide().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralReportInstruction.CollateralReportInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralReportInstruction.CollateralReportInstructionBuilder o = (CollateralReportInstruction.CollateralReportInstructionBuilder) other;
			
			merger.mergeRosetta(getCollateralDetails(), o.getCollateralDetails(), this::setCollateralDetails);
			merger.mergeRosetta(getReportableInformation(), o.getReportableInformation(), this::setReportableInformation);
			merger.mergeRosetta(getReportingSide(), o.getReportingSide(), this::setReportingSide);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralReportInstruction _that = getType().cast(o);
		
			if (!Objects.equals(collateralDetails, _that.getCollateralDetails())) return false;
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralDetails != null ? collateralDetails.hashCode() : 0);
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralReportInstructionBuilder {" +
				"collateralDetails=" + this.collateralDetails + ", " +
				"reportableInformation=" + this.reportableInformation + ", " +
				"reportingSide=" + this.reportingSide +
			'}';
		}
	}
}
