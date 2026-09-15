package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.MarginPortfolio3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the unique codes.
 * @version ${project.version}
 */
@RosettaDataType(value="MarginPortfolio3", builder=MarginPortfolio3.MarginPortfolio3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MarginPortfolio3", model="iso20022", builder=MarginPortfolio3.MarginPortfolio3BuilderImpl.class, version="${project.version}")
public interface MarginPortfolio3 extends RosettaModelObject {

	MarginPortfolio3Meta metaData = new MarginPortfolio3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.    Usage:  NoCode is reported if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement or if no collateral is posted or received.
	 */
	PortfolioCode5Choice getInitlMrgnPrtflCd();
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.    Usage:  NoCode is reported if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement or if no collateral is posted or received.
	 */
	PortfolioCode5Choice getVartnMrgnPrtflCd();

	/*********************** Build Methods  ***********************/
	MarginPortfolio3 build();
	
	MarginPortfolio3.MarginPortfolio3Builder toBuilder();
	
	static MarginPortfolio3.MarginPortfolio3Builder builder() {
		return new MarginPortfolio3.MarginPortfolio3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginPortfolio3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginPortfolio3> getType() {
		return MarginPortfolio3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initlMrgnPrtflCd"), processor, PortfolioCode5Choice.class, getInitlMrgnPrtflCd());
		processRosetta(path.newSubPath("vartnMrgnPrtflCd"), processor, PortfolioCode5Choice.class, getVartnMrgnPrtflCd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginPortfolio3Builder extends MarginPortfolio3, RosettaModelObjectBuilder {
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getOrCreateInitlMrgnPrtflCd();
		@Override
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getInitlMrgnPrtflCd();
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getOrCreateVartnMrgnPrtflCd();
		@Override
		PortfolioCode5Choice.PortfolioCode5ChoiceBuilder getVartnMrgnPrtflCd();
		MarginPortfolio3.MarginPortfolio3Builder setInitlMrgnPrtflCd(PortfolioCode5Choice initlMrgnPrtflCd);
		MarginPortfolio3.MarginPortfolio3Builder setVartnMrgnPrtflCd(PortfolioCode5Choice vartnMrgnPrtflCd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initlMrgnPrtflCd"), processor, PortfolioCode5Choice.PortfolioCode5ChoiceBuilder.class, getInitlMrgnPrtflCd());
			processRosetta(path.newSubPath("vartnMrgnPrtflCd"), processor, PortfolioCode5Choice.PortfolioCode5ChoiceBuilder.class, getVartnMrgnPrtflCd());
		}
		

		MarginPortfolio3.MarginPortfolio3Builder prune();
	}

	/*********************** Immutable Implementation of MarginPortfolio3  ***********************/
	class MarginPortfolio3Impl implements MarginPortfolio3 {
		private final PortfolioCode5Choice initlMrgnPrtflCd;
		private final PortfolioCode5Choice vartnMrgnPrtflCd;
		
		protected MarginPortfolio3Impl(MarginPortfolio3.MarginPortfolio3Builder builder) {
			this.initlMrgnPrtflCd = ofNullable(builder.getInitlMrgnPrtflCd()).map(f->f.build()).orElse(null);
			this.vartnMrgnPrtflCd = ofNullable(builder.getVartnMrgnPrtflCd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initlMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
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
		public MarginPortfolio3 build() {
			return this;
		}
		
		@Override
		public MarginPortfolio3.MarginPortfolio3Builder toBuilder() {
			MarginPortfolio3.MarginPortfolio3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginPortfolio3.MarginPortfolio3Builder builder) {
			ofNullable(getInitlMrgnPrtflCd()).ifPresent(builder::setInitlMrgnPrtflCd);
			ofNullable(getVartnMrgnPrtflCd()).ifPresent(builder::setVartnMrgnPrtflCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginPortfolio3 _that = getType().cast(o);
		
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
			return "MarginPortfolio3 {" +
				"initlMrgnPrtflCd=" + this.initlMrgnPrtflCd + ", " +
				"vartnMrgnPrtflCd=" + this.vartnMrgnPrtflCd +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginPortfolio3  ***********************/
	class MarginPortfolio3BuilderImpl implements MarginPortfolio3.MarginPortfolio3Builder {
	
		protected PortfolioCode5Choice.PortfolioCode5ChoiceBuilder initlMrgnPrtflCd;
		protected PortfolioCode5Choice.PortfolioCode5ChoiceBuilder vartnMrgnPrtflCd;
		
		@Override
		@RosettaAttribute("initlMrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@Required
		@RuneAttribute("initlMrgnPrtflCd")
		@Override
		public MarginPortfolio3.MarginPortfolio3Builder setInitlMrgnPrtflCd(PortfolioCode5Choice _initlMrgnPrtflCd) {
			this.initlMrgnPrtflCd = _initlMrgnPrtflCd == null ? null : _initlMrgnPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnPrtflCd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnPrtflCd")
		@Override
		public MarginPortfolio3.MarginPortfolio3Builder setVartnMrgnPrtflCd(PortfolioCode5Choice _vartnMrgnPrtflCd) {
			this.vartnMrgnPrtflCd = _vartnMrgnPrtflCd == null ? null : _vartnMrgnPrtflCd.toBuilder();
			return this;
		}
		
		@Override
		public MarginPortfolio3 build() {
			return new MarginPortfolio3.MarginPortfolio3Impl(this);
		}
		
		@Override
		public MarginPortfolio3.MarginPortfolio3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginPortfolio3.MarginPortfolio3Builder prune() {
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
		public MarginPortfolio3.MarginPortfolio3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginPortfolio3.MarginPortfolio3Builder o = (MarginPortfolio3.MarginPortfolio3Builder) other;
			
			merger.mergeRosetta(getInitlMrgnPrtflCd(), o.getInitlMrgnPrtflCd(), this::setInitlMrgnPrtflCd);
			merger.mergeRosetta(getVartnMrgnPrtflCd(), o.getVartnMrgnPrtflCd(), this::setVartnMrgnPrtflCd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginPortfolio3 _that = getType().cast(o);
		
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
			return "MarginPortfolio3Builder {" +
				"initlMrgnPrtflCd=" + this.initlMrgnPrtflCd + ", " +
				"vartnMrgnPrtflCd=" + this.vartnMrgnPrtflCd +
			'}';
		}
	}
}
