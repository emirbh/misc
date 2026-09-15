package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.PortfolioCode3ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Element is a choice between a known portfolio code and a code applicable when the code is unknown.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioCode3Choice", builder=PortfolioCode3Choice.PortfolioCode3ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="PortfolioCode3Choice", model="iso20022", builder=PortfolioCode3Choice.PortfolioCode3ChoiceBuilderImpl.class, version="${project.version}")
public interface PortfolioCode3Choice extends RosettaModelObject {

	PortfolioCode3ChoiceMeta metaData = new PortfolioCode3ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique code determined by the reporting counterparty to identify the portfolio if collateral is reported on a portfolio basis.
	 */
	String getCd();
	/**
	 * Collateralisation was performed on a transaction level basis or if the collateral portfolio code is not known at the time of reporting.
	 */
	NotApplicable1Code getNoPrtfl();

	/*********************** Build Methods  ***********************/
	PortfolioCode3Choice build();
	
	PortfolioCode3Choice.PortfolioCode3ChoiceBuilder toBuilder();
	
	static PortfolioCode3Choice.PortfolioCode3ChoiceBuilder builder() {
		return new PortfolioCode3Choice.PortfolioCode3ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioCode3Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PortfolioCode3Choice> getType() {
		return PortfolioCode3Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
		processor.processBasic(path.newSubPath("noPrtfl"), NotApplicable1Code.class, getNoPrtfl(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioCode3ChoiceBuilder extends PortfolioCode3Choice, RosettaModelObjectBuilder {
		PortfolioCode3Choice.PortfolioCode3ChoiceBuilder setCd(String cd);
		PortfolioCode3Choice.PortfolioCode3ChoiceBuilder setNoPrtfl(NotApplicable1Code noPrtfl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
			processor.processBasic(path.newSubPath("noPrtfl"), NotApplicable1Code.class, getNoPrtfl(), this);
		}
		

		PortfolioCode3Choice.PortfolioCode3ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioCode3Choice  ***********************/
	class PortfolioCode3ChoiceImpl implements PortfolioCode3Choice {
		private final String cd;
		private final NotApplicable1Code noPrtfl;
		
		protected PortfolioCode3ChoiceImpl(PortfolioCode3Choice.PortfolioCode3ChoiceBuilder builder) {
			this.cd = builder.getCd();
			this.noPrtfl = builder.getNoPrtfl();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noPrtfl")
		public NotApplicable1Code getNoPrtfl() {
			return noPrtfl;
		}
		
		@Override
		public PortfolioCode3Choice build() {
			return this;
		}
		
		@Override
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder toBuilder() {
			PortfolioCode3Choice.PortfolioCode3ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioCode3Choice.PortfolioCode3ChoiceBuilder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
			ofNullable(getNoPrtfl()).ifPresent(builder::setNoPrtfl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioCode3Choice _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(noPrtfl, _that.getNoPrtfl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			_result = 31 * _result + (noPrtfl != null ? noPrtfl.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioCode3Choice {" +
				"cd=" + this.cd + ", " +
				"noPrtfl=" + this.noPrtfl +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioCode3Choice  ***********************/
	class PortfolioCode3ChoiceBuilderImpl implements PortfolioCode3Choice.PortfolioCode3ChoiceBuilder {
	
		protected String cd;
		protected NotApplicable1Code noPrtfl;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noPrtfl")
		public NotApplicable1Code getNoPrtfl() {
			return noPrtfl;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cd")
		@Override
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder setCd(String _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@RosettaAttribute("noPrtfl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noPrtfl")
		@Override
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder setNoPrtfl(NotApplicable1Code _noPrtfl) {
			this.noPrtfl = _noPrtfl == null ? null : _noPrtfl;
			return this;
		}
		
		@Override
		public PortfolioCode3Choice build() {
			return new PortfolioCode3Choice.PortfolioCode3ChoiceImpl(this);
		}
		
		@Override
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			if (getNoPrtfl()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioCode3Choice.PortfolioCode3ChoiceBuilder o = (PortfolioCode3Choice.PortfolioCode3ChoiceBuilder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			merger.mergeBasic(getNoPrtfl(), o.getNoPrtfl(), this::setNoPrtfl);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioCode3Choice _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(noPrtfl, _that.getNoPrtfl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			_result = 31 * _result + (noPrtfl != null ? noPrtfl.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioCode3ChoiceBuilder {" +
				"cd=" + this.cd + ", " +
				"noPrtfl=" + this.noPrtfl +
			'}';
		}
	}
}
