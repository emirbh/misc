package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.CollateralPortfolioCode5ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the unique codes identifying the portfolio.
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralPortfolioCode5Choice", builder=CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="CollateralPortfolioCode5Choice", model="iso20022", builder=CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilderImpl.class, version="${project.version}")
public interface CollateralPortfolioCode5Choice extends RosettaModelObject {

	CollateralPortfolioCode5ChoiceMeta metaData = new CollateralPortfolioCode5ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.    Usage:  NoPortfolio is reported if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement or if no collateral is posted or received.
	 */
	PortfolioCode3Choice getPrtfl();
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the margin portfolio if the collateral is posted on a margin portfolio basis.
	 */
	MarginPortfolio3 getMrgnPrtflCd();

	/*********************** Build Methods  ***********************/
	CollateralPortfolioCode5Choice build();
	
	CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder toBuilder();
	
	static CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder builder() {
		return new CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPortfolioCode5Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralPortfolioCode5Choice> getType() {
		return CollateralPortfolioCode5Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("prtfl"), processor, PortfolioCode3Choice.class, getPrtfl());
		processRosetta(path.newSubPath("mrgnPrtflCd"), processor, MarginPortfolio3.class, getMrgnPrtflCd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPortfolioCode5ChoiceBuilder extends CollateralPortfolioCode5Choice, RosettaModelObjectBuilder {
		PortfolioCode3Choice.PortfolioCode3ChoiceBuilder getOrCreatePrtfl();
		@Override
		PortfolioCode3Choice.PortfolioCode3ChoiceBuilder getPrtfl();
		MarginPortfolio3.MarginPortfolio3Builder getOrCreateMrgnPrtflCd();
		@Override
		MarginPortfolio3.MarginPortfolio3Builder getMrgnPrtflCd();
		CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder setPrtfl(PortfolioCode3Choice prtfl);
		CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder setMrgnPrtflCd(MarginPortfolio3 mrgnPrtflCd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("prtfl"), processor, PortfolioCode3Choice.PortfolioCode3ChoiceBuilder.class, getPrtfl());
			processRosetta(path.newSubPath("mrgnPrtflCd"), processor, MarginPortfolio3.MarginPortfolio3Builder.class, getMrgnPrtflCd());
		}
		

		CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralPortfolioCode5Choice  ***********************/
	class CollateralPortfolioCode5ChoiceImpl implements CollateralPortfolioCode5Choice {
		private final PortfolioCode3Choice prtfl;
		private final MarginPortfolio3 mrgnPrtflCd;
		
		protected CollateralPortfolioCode5ChoiceImpl(CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder builder) {
			this.prtfl = ofNullable(builder.getPrtfl()).map(f->f.build()).orElse(null);
			this.mrgnPrtflCd = ofNullable(builder.getMrgnPrtflCd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtfl")
		public PortfolioCode3Choice getPrtfl() {
			return prtfl;
		}
		
		@Override
		@RosettaAttribute("mrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mrgnPrtflCd")
		public MarginPortfolio3 getMrgnPrtflCd() {
			return mrgnPrtflCd;
		}
		
		@Override
		public CollateralPortfolioCode5Choice build() {
			return this;
		}
		
		@Override
		public CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder toBuilder() {
			CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder builder) {
			ofNullable(getPrtfl()).ifPresent(builder::setPrtfl);
			ofNullable(getMrgnPrtflCd()).ifPresent(builder::setMrgnPrtflCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioCode5Choice _that = getType().cast(o);
		
			if (!Objects.equals(prtfl, _that.getPrtfl())) return false;
			if (!Objects.equals(mrgnPrtflCd, _that.getMrgnPrtflCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtfl != null ? prtfl.hashCode() : 0);
			_result = 31 * _result + (mrgnPrtflCd != null ? mrgnPrtflCd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioCode5Choice {" +
				"prtfl=" + this.prtfl + ", " +
				"mrgnPrtflCd=" + this.mrgnPrtflCd +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralPortfolioCode5Choice  ***********************/
	class CollateralPortfolioCode5ChoiceBuilderImpl implements CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder {
	
		protected PortfolioCode3Choice.PortfolioCode3ChoiceBuilder prtfl;
		protected MarginPortfolio3.MarginPortfolio3Builder mrgnPrtflCd;
		
		@Override
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtfl")
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder getPrtfl() {
			return prtfl;
		}
		
		@Override
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder getOrCreatePrtfl() {
			PortfolioCode3Choice.PortfolioCode3ChoiceBuilder result;
			if (prtfl!=null) {
				result = prtfl;
			}
			else {
				result = prtfl = PortfolioCode3Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mrgnPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mrgnPrtflCd")
		public MarginPortfolio3.MarginPortfolio3Builder getMrgnPrtflCd() {
			return mrgnPrtflCd;
		}
		
		@Override
		public MarginPortfolio3.MarginPortfolio3Builder getOrCreateMrgnPrtflCd() {
			MarginPortfolio3.MarginPortfolio3Builder result;
			if (mrgnPrtflCd!=null) {
				result = mrgnPrtflCd;
			}
			else {
				result = mrgnPrtflCd = MarginPortfolio3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtfl")
		@Override
		public CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder setPrtfl(PortfolioCode3Choice _prtfl) {
			this.prtfl = _prtfl == null ? null : _prtfl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mrgnPrtflCd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mrgnPrtflCd")
		@Override
		public CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder setMrgnPrtflCd(MarginPortfolio3 _mrgnPrtflCd) {
			this.mrgnPrtflCd = _mrgnPrtflCd == null ? null : _mrgnPrtflCd.toBuilder();
			return this;
		}
		
		@Override
		public CollateralPortfolioCode5Choice build() {
			return new CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceImpl(this);
		}
		
		@Override
		public CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder prune() {
			if (prtfl!=null && !prtfl.prune().hasData()) prtfl = null;
			if (mrgnPrtflCd!=null && !mrgnPrtflCd.prune().hasData()) mrgnPrtflCd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrtfl()!=null && getPrtfl().hasData()) return true;
			if (getMrgnPrtflCd()!=null && getMrgnPrtflCd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder o = (CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder) other;
			
			merger.mergeRosetta(getPrtfl(), o.getPrtfl(), this::setPrtfl);
			merger.mergeRosetta(getMrgnPrtflCd(), o.getMrgnPrtflCd(), this::setMrgnPrtflCd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioCode5Choice _that = getType().cast(o);
		
			if (!Objects.equals(prtfl, _that.getPrtfl())) return false;
			if (!Objects.equals(mrgnPrtflCd, _that.getMrgnPrtflCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtfl != null ? prtfl.hashCode() : 0);
			_result = 31 * _result + (mrgnPrtflCd != null ? mrgnPrtflCd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioCode5ChoiceBuilder {" +
				"prtfl=" + this.prtfl + ", " +
				"mrgnPrtflCd=" + this.mrgnPrtflCd +
			'}';
		}
	}
}
