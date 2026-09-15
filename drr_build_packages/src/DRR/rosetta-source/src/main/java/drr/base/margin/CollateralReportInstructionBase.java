package drr.base.margin;

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
import drr.base.margin.meta.CollateralReportInstructionBaseMeta;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.ReportingSide;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CollateralReportInstructionBase", builder=CollateralReportInstructionBase.CollateralReportInstructionBaseBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CollateralReportInstructionBase", model="drr", builder=CollateralReportInstructionBase.CollateralReportInstructionBaseBuilderImpl.class, version="7.7.0")
public interface CollateralReportInstructionBase extends ReportableCollateralBase {

	CollateralReportInstructionBaseMeta metaData = new CollateralReportInstructionBaseMeta();

	/*********************** Getter Methods  ***********************/
	ReportingSide getReportingSide();

	/*********************** Build Methods  ***********************/
	CollateralReportInstructionBase build();
	
	CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder toBuilder();
	
	static CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder builder() {
		return new CollateralReportInstructionBase.CollateralReportInstructionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralReportInstructionBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralReportInstructionBase> getType() {
		return CollateralReportInstructionBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.class, getCollateralDetails());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformationBase.class, getReportableInformation());
		processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.class, getReportingSide());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralReportInstructionBaseBuilder extends CollateralReportInstructionBase, ReportableCollateralBase.ReportableCollateralBaseBuilder {
		ReportingSide.ReportingSideBuilder getOrCreateReportingSide();
		@Override
		ReportingSide.ReportingSideBuilder getReportingSide();
		@Override
		CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder setCollateralDetails(CollateralDetails collateralDetails);
		@Override
		CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder setReportableInformation(ReportableInformationBase reportableInformation);
		CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder setReportingSide(ReportingSide reportingSide);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.CollateralDetailsBuilder.class, getCollateralDetails());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformationBase.ReportableInformationBaseBuilder.class, getReportableInformation());
			processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.ReportingSideBuilder.class, getReportingSide());
		}
		

		CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralReportInstructionBase  ***********************/
	class CollateralReportInstructionBaseImpl extends ReportableCollateralBase.ReportableCollateralBaseImpl implements CollateralReportInstructionBase {
		private final ReportingSide reportingSide;
		
		protected CollateralReportInstructionBaseImpl(CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder builder) {
			super(builder);
			this.reportingSide = ofNullable(builder.getReportingSide()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingSide")
		public ReportingSide getReportingSide() {
			return reportingSide;
		}
		
		@Override
		public CollateralReportInstructionBase build() {
			return this;
		}
		
		@Override
		public CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder toBuilder() {
			CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportingSide()).ifPresent(builder::setReportingSide);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralReportInstructionBase _that = getType().cast(o);
		
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralReportInstructionBase {" +
				"reportingSide=" + this.reportingSide +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CollateralReportInstructionBase  ***********************/
	class CollateralReportInstructionBaseBuilderImpl extends ReportableCollateralBase.ReportableCollateralBaseBuilderImpl implements CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder {
	
		protected ReportingSide.ReportingSideBuilder reportingSide;
		
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
		public CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder setCollateralDetails(CollateralDetails _collateralDetails) {
			this.collateralDetails = _collateralDetails == null ? null : _collateralDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingSide")
		@Override
		public CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder setReportingSide(ReportingSide _reportingSide) {
			this.reportingSide = _reportingSide == null ? null : _reportingSide.toBuilder();
			return this;
		}
		
		@Override
		public CollateralReportInstructionBase build() {
			return new CollateralReportInstructionBase.CollateralReportInstructionBaseImpl(this);
		}
		
		@Override
		public CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder prune() {
			super.prune();
			if (reportingSide!=null && !reportingSide.prune().hasData()) reportingSide = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReportingSide()!=null && getReportingSide().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder o = (CollateralReportInstructionBase.CollateralReportInstructionBaseBuilder) other;
			
			merger.mergeRosetta(getReportingSide(), o.getReportingSide(), this::setReportingSide);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CollateralReportInstructionBase _that = getType().cast(o);
		
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralReportInstructionBaseBuilder {" +
				"reportingSide=" + this.reportingSide +
			'}' + " " + super.toString();
		}
	}
}
