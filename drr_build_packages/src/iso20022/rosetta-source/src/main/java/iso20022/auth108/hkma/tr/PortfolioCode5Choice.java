package iso20022.auth108.hkma.tr;

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
import iso20022.auth108.hkma.tr.meta.PortfolioCode5ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Element is a choice between a known portfolio code and a code applicable when the code is unknown.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioCode5Choice", builder=PortfolioCode5Choice.PortfolioCode5ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="PortfolioCode5Choice", model="iso20022", builder=PortfolioCode5Choice.PortfolioCode5ChoiceBuilderImpl.class, version="${project.version}")
public interface PortfolioCode5Choice extends RosettaModelObject {

	PortfolioCode5ChoiceMeta metaData = new PortfolioCode5ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique code determined by the reporting counterparty to identify the portfolio if collateral is reported on a portfolio basis.
	 */
	PortfolioIdentification3 getPrtfl();
	/**
	 * Collateralisation was performed on a transaction level basis or if the collateral portfolio code is not known at the time of reporting.
	 */
	NotApplicable1Code getNoPrtfl();

	/*********************** Build Methods  ***********************/
	PortfolioCode5Choice build();
	
	PortfolioCode5Choice.PortfolioCode5ChoiceBuilder toBuilder();
	
	static PortfolioCode5Choice.PortfolioCode5ChoiceBuilder builder() {
		return new PortfolioCode5Choice.PortfolioCode5ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioCode5Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PortfolioCode5Choice> getType() {
		return PortfolioCode5Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("prtfl"), processor, PortfolioIdentification3.class, getPrtfl());
		processor.processBasic(path.newSubPath("noPrtfl"), NotApplicable1Code.class, getNoPrtfl(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioCode5ChoiceBuilder extends PortfolioCode5Choice, RosettaModelObjectBuilder {
		PortfolioIdentification3.PortfolioIdentification3Builder getOrCreatePrtfl();
		@Override
		PortfolioIdentification3.PortfolioIdentification3Builder getPrtfl();
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder setPrtfl(PortfolioIdentification3 prtfl);
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder setNoPrtfl(NotApplicable1Code noPrtfl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("prtfl"), processor, PortfolioIdentification3.PortfolioIdentification3Builder.class, getPrtfl());
			processor.processBasic(path.newSubPath("noPrtfl"), NotApplicable1Code.class, getNoPrtfl(), this);
		}
		

		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioCode5Choice  ***********************/
	class PortfolioCode5ChoiceImpl implements PortfolioCode5Choice {
		private final PortfolioIdentification3 prtfl;
		private final NotApplicable1Code noPrtfl;
		
		protected PortfolioCode5ChoiceImpl(PortfolioCode5Choice.PortfolioCode5ChoiceBuilder builder) {
			this.prtfl = ofNullable(builder.getPrtfl()).map(f->f.build()).orElse(null);
			this.noPrtfl = builder.getNoPrtfl();
		}
		
		@Override
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtfl")
		public PortfolioIdentification3 getPrtfl() {
			return prtfl;
		}
		
		@Override
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noPrtfl")
		public NotApplicable1Code getNoPrtfl() {
			return noPrtfl;
		}
		
		@Override
		public PortfolioCode5Choice build() {
			return this;
		}
		
		@Override
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder toBuilder() {
			PortfolioCode5Choice.PortfolioCode5ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioCode5Choice.PortfolioCode5ChoiceBuilder builder) {
			ofNullable(getPrtfl()).ifPresent(builder::setPrtfl);
			ofNullable(getNoPrtfl()).ifPresent(builder::setNoPrtfl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioCode5Choice _that = getType().cast(o);
		
			if (!Objects.equals(prtfl, _that.getPrtfl())) return false;
			if (!Objects.equals(noPrtfl, _that.getNoPrtfl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtfl != null ? prtfl.hashCode() : 0);
			_result = 31 * _result + (noPrtfl != null ? noPrtfl.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioCode5Choice {" +
				"prtfl=" + this.prtfl + ", " +
				"noPrtfl=" + this.noPrtfl +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioCode5Choice  ***********************/
	class PortfolioCode5ChoiceBuilderImpl implements PortfolioCode5Choice.PortfolioCode5ChoiceBuilder {
	
		protected PortfolioIdentification3.PortfolioIdentification3Builder prtfl;
		protected NotApplicable1Code noPrtfl;
		
		@Override
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtfl")
		public PortfolioIdentification3.PortfolioIdentification3Builder getPrtfl() {
			return prtfl;
		}
		
		@Override
		public PortfolioIdentification3.PortfolioIdentification3Builder getOrCreatePrtfl() {
			PortfolioIdentification3.PortfolioIdentification3Builder result;
			if (prtfl!=null) {
				result = prtfl;
			}
			else {
				result = prtfl = PortfolioIdentification3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noPrtfl")
		public NotApplicable1Code getNoPrtfl() {
			return noPrtfl;
		}
		
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtfl")
		@Override
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder setPrtfl(PortfolioIdentification3 _prtfl) {
			this.prtfl = _prtfl == null ? null : _prtfl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noPrtfl")
		@Override
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder setNoPrtfl(NotApplicable1Code _noPrtfl) {
			this.noPrtfl = _noPrtfl == null ? null : _noPrtfl;
			return this;
		}
		
		@Override
		public PortfolioCode5Choice build() {
			return new PortfolioCode5Choice.PortfolioCode5ChoiceImpl(this);
		}
		
		@Override
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder prune() {
			if (prtfl!=null && !prtfl.prune().hasData()) prtfl = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrtfl()!=null && getPrtfl().hasData()) return true;
			if (getNoPrtfl()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioCode5Choice.PortfolioCode5ChoiceBuilder o = (PortfolioCode5Choice.PortfolioCode5ChoiceBuilder) other;
			
			merger.mergeRosetta(getPrtfl(), o.getPrtfl(), this::setPrtfl);
			
			merger.mergeBasic(getNoPrtfl(), o.getNoPrtfl(), this::setNoPrtfl);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioCode5Choice _that = getType().cast(o);
		
			if (!Objects.equals(prtfl, _that.getPrtfl())) return false;
			if (!Objects.equals(noPrtfl, _that.getNoPrtfl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtfl != null ? prtfl.hashCode() : 0);
			_result = 31 * _result + (noPrtfl != null ? noPrtfl.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioCode5ChoiceBuilder {" +
				"prtfl=" + this.prtfl + ", " +
				"noPrtfl=" + this.noPrtfl +
			'}';
		}
	}
}
