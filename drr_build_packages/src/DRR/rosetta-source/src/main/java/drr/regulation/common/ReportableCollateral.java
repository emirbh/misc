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
import drr.base.margin.ReportableCollateralBase;
import drr.base.trade.ReportableInformationBase;
import drr.regulation.common.meta.ReportableCollateralMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableCollateral", builder=ReportableCollateral.ReportableCollateralBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableCollateral", model="drr", builder=ReportableCollateral.ReportableCollateralBuilderImpl.class, version="7.7.0")
public interface ReportableCollateral extends ReportableCollateralBase {

	ReportableCollateralMeta metaData = new ReportableCollateralMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Additional information required for a reportable transaction, including the reporting regime.
	 */
	@Override
	ReportableInformation getReportableInformation();

	/*********************** Build Methods  ***********************/
	ReportableCollateral build();
	
	ReportableCollateral.ReportableCollateralBuilder toBuilder();
	
	static ReportableCollateral.ReportableCollateralBuilder builder() {
		return new ReportableCollateral.ReportableCollateralBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableCollateral> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableCollateral> getType() {
		return ReportableCollateral.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.class, getCollateralDetails());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.class, getReportableInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableCollateralBuilder extends ReportableCollateral, ReportableCollateralBase.ReportableCollateralBaseBuilder {
		ReportableInformation.ReportableInformationBuilder getOrCreateReportableInformation();
		@Override
		ReportableInformation.ReportableInformationBuilder getReportableInformation();
		@Override
		ReportableCollateral.ReportableCollateralBuilder setCollateralDetails(CollateralDetails collateralDetails);
		@Override
		ReportableCollateral.ReportableCollateralBuilder setReportableInformation(ReportableInformationBase reportableInformation);
		ReportableCollateral.ReportableCollateralBuilder setReportableInformation(ReportableInformation reportableInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.CollateralDetailsBuilder.class, getCollateralDetails());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.ReportableInformationBuilder.class, getReportableInformation());
		}
		

		ReportableCollateral.ReportableCollateralBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableCollateral  ***********************/
	class ReportableCollateralImpl extends ReportableCollateralBase.ReportableCollateralBaseImpl implements ReportableCollateral {
		private final ReportableInformation reportableInformation;
		
		protected ReportableCollateralImpl(ReportableCollateral.ReportableCollateralBuilder builder) {
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
		public ReportableCollateral build() {
			return this;
		}
		
		@Override
		public ReportableCollateral.ReportableCollateralBuilder toBuilder() {
			ReportableCollateral.ReportableCollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableCollateral.ReportableCollateralBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportableInformation()).ifPresent(builder::setReportableInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReportableCollateral _that = getType().cast(o);
		
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
			return "ReportableCollateral {" +
				"reportableInformation=" + this.reportableInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReportableCollateral  ***********************/
	class ReportableCollateralBuilderImpl implements ReportableCollateral.ReportableCollateralBuilder {
	
		protected CollateralDetails.CollateralDetailsBuilder collateralDetails;
		protected ReportableInformation.ReportableInformationBuilder reportableInformation;
		
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
		
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralDetails")
		@Override
		public ReportableCollateral.ReportableCollateralBuilder setCollateralDetails(CollateralDetails _collateralDetails) {
			this.collateralDetails = _collateralDetails == null ? null : _collateralDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public ReportableCollateral.ReportableCollateralBuilder setReportableInformation(ReportableInformation _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public ReportableCollateral.ReportableCollateralBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			final ReportableInformation ifThenElseResult;
			if (_reportableInformation == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _reportableInformation instanceof ReportableInformation ? ReportableInformation.class.cast(_reportableInformation) : null;
			}
			return setReportableInformation(ifThenElseResult);
		}
		
		@Override
		public ReportableCollateral build() {
			return new ReportableCollateral.ReportableCollateralImpl(this);
		}
		
		@Override
		public ReportableCollateral.ReportableCollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableCollateral.ReportableCollateralBuilder prune() {
			if (collateralDetails!=null && !collateralDetails.prune().hasData()) collateralDetails = null;
			if (reportableInformation!=null && !reportableInformation.prune().hasData()) reportableInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralDetails()!=null && getCollateralDetails().hasData()) return true;
			if (getReportableInformation()!=null && getReportableInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableCollateral.ReportableCollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableCollateral.ReportableCollateralBuilder o = (ReportableCollateral.ReportableCollateralBuilder) other;
			
			merger.mergeRosetta(getCollateralDetails(), o.getCollateralDetails(), this::setCollateralDetails);
			merger.mergeRosetta(getReportableInformation(), o.getReportableInformation(), this::setReportableInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableCollateral _that = getType().cast(o);
		
			if (!Objects.equals(collateralDetails, _that.getCollateralDetails())) return false;
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralDetails != null ? collateralDetails.hashCode() : 0);
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableCollateralBuilder {" +
				"collateralDetails=" + this.collateralDetails + ", " +
				"reportableInformation=" + this.reportableInformation +
			'}';
		}
	}
}
