package iso20022.auth108.hkma.dtcc;

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
import iso20022.auth108.hkma.dtcc.meta.MarginPortfolio4Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the margin portfolio unique codes.
 * @version ${project.version}
 */
@RosettaDataType(value="MarginPortfolio4", builder=MarginPortfolio4.MarginPortfolio4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MarginPortfolio4", model="iso20022", builder=MarginPortfolio4.MarginPortfolio4BuilderImpl.class, version="${project.version}")
public interface MarginPortfolio4 extends RosettaModelObject {

	MarginPortfolio4Meta metaData = new MarginPortfolio4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.  Usage: NoPortfolio is reported if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement or if no collateral is posted or received.
	 */
	PortfolioCode5Choice getInitlMrgnPrtflCd();
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.  Usage: NoPortfolio is reported if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement or if no collateral is posted or received.
	 */
	PortfolioCode5Choice getVartnMrgnPrtflCd();

	/*********************** Build Methods  ***********************/
	MarginPortfolio4 build();
	
	MarginPortfolio4.MarginPortfolio4Builder toBuilder();
	
	static MarginPortfolio4.MarginPortfolio4Builder builder() {
		return new MarginPortfolio4.MarginPortfolio4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginPortfolio4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginPortfolio4> getType() {
		return MarginPortfolio4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initlMrgnPrtflCd"), processor, PortfolioCode5Choice.class, getInitlMrgnPrtflCd());
		processRosetta(path.newSubPath("vartnMrgnPrtflCd"), processor, PortfolioCode5Choice.class, getVartnMrgnPrtflCd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginPortfolio4Builder extends MarginPortfolio4, RosettaModelObjectBuilder {
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getOrCreateInitlMrgnPrtflCd();
		@Override
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getInitlMrgnPrtflCd();
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getOrCreateVartnMrgnPrtflCd();
		@Override
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getVartnMrgnPrtflCd();
		MarginPortfolio4.MarginPortfolio4Builder setInitlMrgnPrtflCd(PortfolioCode5Choice initlMrgnPrtflCd);
		MarginPortfolio4.MarginPortfolio4Builder setVartnMrgnPrtflCd(PortfolioCode5Choice vartnMrgnPrtflCd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initlMrgnPrtflCd"), processor, PortfolioCode5Choice.PortfolioCode5ChoiceBuilder.class, getInitlMrgnPrtflCd());
			processRosetta(path.newSubPath("vartnMrgnPrtflCd"), processor, PortfolioCode5Choice.PortfolioCode5ChoiceBuilder.class, getVartnMrgnPrtflCd());
		}
		

		MarginPortfolio4.MarginPortfolio4Builder prune();
	}

	/*********************** Immutable Implementation of MarginPortfolio4  ***********************/
	class MarginPortfolio4Impl implements MarginPortfolio4 {
		private final PortfolioCode5Choice initlMrgnPrtflCd;
		private final PortfolioCode5Choice vartnMrgnPrtflCd;
		
		protected MarginPortfolio4Impl(MarginPortfolio4.MarginPortfolio4Builder builder) {
			this.initlMrgnPrtflCd = ofNullable(builder.getInitlMrgnPrtflCd()).map(f->f.build()).orElse(null);
			this.vartnMrgnPrtflCd = ofNullable(builder.getVartnMrgnPrtflCd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initlMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPrtflCd")
		public PortfolioCode5Choice getInitlMrgnPrtflCd() {
			return initlMrgnPrtflCd;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPrtflCd")
		public PortfolioCode5Choice getVartnMrgnPrtflCd() {
			return vartnMrgnPrtflCd;
		}
		
		@Override
		public MarginPortfolio4 build() {
			return this;
		}
		
		@Override
		public MarginPortfolio4.MarginPortfolio4Builder toBuilder() {
			MarginPortfolio4.MarginPortfolio4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginPortfolio4.MarginPortfolio4Builder builder) {
			ofNullable(getInitlMrgnPrtflCd()).ifPresent(builder::setInitlMrgnPrtflCd);
			ofNullable(getVartnMrgnPrtflCd()).ifPresent(builder::setVartnMrgnPrtflCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginPortfolio4 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPrtflCd, _that.getInitlMrgnPrtflCd())) return false;
			if (!Objects.equals(vartnMrgnPrtflCd, _that.getVartnMrgnPrtflCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPrtflCd != null ? initlMrgnPrtflCd.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPrtflCd != null ? vartnMrgnPrtflCd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginPortfolio4 {" +
				"initlMrgnPrtflCd=" + this.initlMrgnPrtflCd + ", " +
				"vartnMrgnPrtflCd=" + this.vartnMrgnPrtflCd +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginPortfolio4  ***********************/
	class MarginPortfolio4BuilderImpl implements MarginPortfolio4.MarginPortfolio4Builder {
	
		protected PortfolioCode5Choice.PortfolioCode5ChoiceBuilder initlMrgnPrtflCd;
		protected PortfolioCode5Choice.PortfolioCode5ChoiceBuilder vartnMrgnPrtflCd;
		
		@Override
		@RosettaAttribute("initlMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPrtflCd")
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getInitlMrgnPrtflCd() {
			return initlMrgnPrtflCd;
		}
		
		@Override
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getOrCreateInitlMrgnPrtflCd() {
			PortfolioCode5Choice.PortfolioCode5ChoiceBuilder result;
			if (initlMrgnPrtflCd!=null) {
				result = initlMrgnPrtflCd;
			}
			else {
				result = initlMrgnPrtflCd = PortfolioCode5Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPrtflCd")
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getVartnMrgnPrtflCd() {
			return vartnMrgnPrtflCd;
		}
		
		@Override
		public PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getOrCreateVartnMrgnPrtflCd() {
			PortfolioCode5Choice.PortfolioCode5ChoiceBuilder result;
			if (vartnMrgnPrtflCd!=null) {
				result = vartnMrgnPrtflCd;
			}
			else {
				result = vartnMrgnPrtflCd = PortfolioCode5Choice.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initlMrgnPrtflCd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnPrtflCd")
		@Override
		public MarginPortfolio4.MarginPortfolio4Builder setInitlMrgnPrtflCd(PortfolioCode5Choice _initlMrgnPrtflCd) {
			this.initlMrgnPrtflCd = _initlMrgnPrtflCd == null ? null : _initlMrgnPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnPrtflCd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnPrtflCd")
		@Override
		public MarginPortfolio4.MarginPortfolio4Builder setVartnMrgnPrtflCd(PortfolioCode5Choice _vartnMrgnPrtflCd) {
			this.vartnMrgnPrtflCd = _vartnMrgnPrtflCd == null ? null : _vartnMrgnPrtflCd.toBuilder();
			return this;
		}
		
		@Override
		public MarginPortfolio4 build() {
			return new MarginPortfolio4.MarginPortfolio4Impl(this);
		}
		
		@Override
		public MarginPortfolio4.MarginPortfolio4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginPortfolio4.MarginPortfolio4Builder prune() {
			if (initlMrgnPrtflCd!=null && !initlMrgnPrtflCd.prune().hasData()) initlMrgnPrtflCd = null;
			if (vartnMrgnPrtflCd!=null && !vartnMrgnPrtflCd.prune().hasData()) vartnMrgnPrtflCd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitlMrgnPrtflCd()!=null && getInitlMrgnPrtflCd().hasData()) return true;
			if (getVartnMrgnPrtflCd()!=null && getVartnMrgnPrtflCd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginPortfolio4.MarginPortfolio4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginPortfolio4.MarginPortfolio4Builder o = (MarginPortfolio4.MarginPortfolio4Builder) other;
			
			merger.mergeRosetta(getInitlMrgnPrtflCd(), o.getInitlMrgnPrtflCd(), this::setInitlMrgnPrtflCd);
			merger.mergeRosetta(getVartnMrgnPrtflCd(), o.getVartnMrgnPrtflCd(), this::setVartnMrgnPrtflCd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginPortfolio4 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPrtflCd, _that.getInitlMrgnPrtflCd())) return false;
			if (!Objects.equals(vartnMrgnPrtflCd, _that.getVartnMrgnPrtflCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPrtflCd != null ? initlMrgnPrtflCd.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPrtflCd != null ? vartnMrgnPrtflCd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginPortfolio4Builder {" +
				"initlMrgnPrtflCd=" + this.initlMrgnPrtflCd + ", " +
				"vartnMrgnPrtflCd=" + this.vartnMrgnPrtflCd +
			'}';
		}
	}
}
