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
import iso20022.auth108.iso.meta.PostedMarginOrCollateral6Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information on the posted margin or collateral of the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="PostedMarginOrCollateral6", builder=PostedMarginOrCollateral6.PostedMarginOrCollateral6BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PostedMarginOrCollateral6", model="iso20022", builder=PostedMarginOrCollateral6.PostedMarginOrCollateral6BuilderImpl.class, version="${project.version}")
public interface PostedMarginOrCollateral6 extends RosettaModelObject {

	PostedMarginOrCollateral6Meta metaData = new PostedMarginOrCollateral6Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Value of the initial margin posted by the reporting counterparty to the other counterparty.  Where initial margin is posted on a portfolio basis, this field should include the overall value of initial margin posted for the portfolio.
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getInitlMrgnPstdPreHrcut();
	/**
	 * Value of the initial margin posted by the reporting counterparty to the other counterparty.  Where initial margin is posted on a portfolio basis, this field should include the overall value of initial margin posted for the portfolio.  Post-haircut values of margins depend on associated risk of changes in collateral value and therefore on the nature of the collateral posted (or collected).
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getInitlMrgnPstdPstHrcut();
	/**
	 * Value of the variation margin posted, including cash settled, by the reporting counterparty to the other counterparty.  Where variation margin is posted on a portfolio basis, this field should include the overall value of variation margin posted for the portfolio.
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getVartnMrgnPstdPreHrcut();
	/**
	 * Value of the variation margin posted, including cash settled, by the reporting counterparty to the other counterparty.  Where variation margin is posted on a portfolio basis, this field should include the overall value of variation margin posted for the portfolio.  Post-haircut values of margins depend on associated risk of changes in collateral value and therefore on the nature of the collateral posted (or collected).
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getVartnMrgnPstdPstHrcut();
	/**
	 * Value of collateral posted in excess of the required collateral.
	 */
	ActiveOrHistoricCurrencyAnd20DecimalAmount getXcssCollPstd();

	/*********************** Build Methods  ***********************/
	PostedMarginOrCollateral6 build();
	
	PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder toBuilder();
	
	static PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder builder() {
		return new PostedMarginOrCollateral6.PostedMarginOrCollateral6BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PostedMarginOrCollateral6> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PostedMarginOrCollateral6> getType() {
		return PostedMarginOrCollateral6.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initlMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getInitlMrgnPstdPreHrcut());
		processRosetta(path.newSubPath("initlMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getInitlMrgnPstdPstHrcut());
		processRosetta(path.newSubPath("vartnMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getVartnMrgnPstdPreHrcut());
		processRosetta(path.newSubPath("vartnMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getVartnMrgnPstdPstHrcut());
		processRosetta(path.newSubPath("xcssCollPstd"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.class, getXcssCollPstd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostedMarginOrCollateral6Builder extends PostedMarginOrCollateral6, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateInitlMrgnPstdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getInitlMrgnPstdPreHrcut();
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateInitlMrgnPstdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getInitlMrgnPstdPstHrcut();
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateVartnMrgnPstdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getVartnMrgnPstdPreHrcut();
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateVartnMrgnPstdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getVartnMrgnPstdPstHrcut();
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateXcssCollPstd();
		@Override
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getXcssCollPstd();
		PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setInitlMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount initlMrgnPstdPreHrcut);
		PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setInitlMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount initlMrgnPstdPstHrcut);
		PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setVartnMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount vartnMrgnPstdPreHrcut);
		PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setVartnMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount vartnMrgnPstdPstHrcut);
		PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setXcssCollPstd(ActiveOrHistoricCurrencyAnd20DecimalAmount xcssCollPstd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initlMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getInitlMrgnPstdPreHrcut());
			processRosetta(path.newSubPath("initlMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getInitlMrgnPstdPstHrcut());
			processRosetta(path.newSubPath("vartnMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getVartnMrgnPstdPreHrcut());
			processRosetta(path.newSubPath("vartnMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getVartnMrgnPstdPstHrcut());
			processRosetta(path.newSubPath("xcssCollPstd"), processor, ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder.class, getXcssCollPstd());
		}
		

		PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder prune();
	}

	/*********************** Immutable Implementation of PostedMarginOrCollateral6  ***********************/
	class PostedMarginOrCollateral6Impl implements PostedMarginOrCollateral6 {
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount initlMrgnPstdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount initlMrgnPstdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount vartnMrgnPstdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount vartnMrgnPstdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd20DecimalAmount xcssCollPstd;
		
		protected PostedMarginOrCollateral6Impl(PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder builder) {
			this.initlMrgnPstdPreHrcut = ofNullable(builder.getInitlMrgnPstdPreHrcut()).map(f->f.build()).orElse(null);
			this.initlMrgnPstdPstHrcut = ofNullable(builder.getInitlMrgnPstdPstHrcut()).map(f->f.build()).orElse(null);
			this.vartnMrgnPstdPreHrcut = ofNullable(builder.getVartnMrgnPstdPreHrcut()).map(f->f.build()).orElse(null);
			this.vartnMrgnPstdPstHrcut = ofNullable(builder.getVartnMrgnPstdPstHrcut()).map(f->f.build()).orElse(null);
			this.xcssCollPstd = ofNullable(builder.getXcssCollPstd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getInitlMrgnPstdPreHrcut() {
			return initlMrgnPstdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getInitlMrgnPstdPstHrcut() {
			return initlMrgnPstdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getVartnMrgnPstdPreHrcut() {
			return vartnMrgnPstdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getVartnMrgnPstdPstHrcut() {
			return vartnMrgnPstdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("xcssCollPstd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xcssCollPstd")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount getXcssCollPstd() {
			return xcssCollPstd;
		}
		
		@Override
		public PostedMarginOrCollateral6 build() {
			return this;
		}
		
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder toBuilder() {
			PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder builder) {
			ofNullable(getInitlMrgnPstdPreHrcut()).ifPresent(builder::setInitlMrgnPstdPreHrcut);
			ofNullable(getInitlMrgnPstdPstHrcut()).ifPresent(builder::setInitlMrgnPstdPstHrcut);
			ofNullable(getVartnMrgnPstdPreHrcut()).ifPresent(builder::setVartnMrgnPstdPreHrcut);
			ofNullable(getVartnMrgnPstdPstHrcut()).ifPresent(builder::setVartnMrgnPstdPstHrcut);
			ofNullable(getXcssCollPstd()).ifPresent(builder::setXcssCollPstd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedMarginOrCollateral6 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPstdPreHrcut, _that.getInitlMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(initlMrgnPstdPstHrcut, _that.getInitlMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPreHrcut, _that.getVartnMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPstHrcut, _that.getVartnMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(xcssCollPstd, _that.getXcssCollPstd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPstdPreHrcut != null ? initlMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (initlMrgnPstdPstHrcut != null ? initlMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPreHrcut != null ? vartnMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPstHrcut != null ? vartnMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (xcssCollPstd != null ? xcssCollPstd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedMarginOrCollateral6 {" +
				"initlMrgnPstdPreHrcut=" + this.initlMrgnPstdPreHrcut + ", " +
				"initlMrgnPstdPstHrcut=" + this.initlMrgnPstdPstHrcut + ", " +
				"vartnMrgnPstdPreHrcut=" + this.vartnMrgnPstdPreHrcut + ", " +
				"vartnMrgnPstdPstHrcut=" + this.vartnMrgnPstdPstHrcut + ", " +
				"xcssCollPstd=" + this.xcssCollPstd +
			'}';
		}
	}

	/*********************** Builder Implementation of PostedMarginOrCollateral6  ***********************/
	class PostedMarginOrCollateral6BuilderImpl implements PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder {
	
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder initlMrgnPstdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder initlMrgnPstdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder vartnMrgnPstdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder vartnMrgnPstdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder xcssCollPstd;
		
		@Override
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getInitlMrgnPstdPreHrcut() {
			return initlMrgnPstdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateInitlMrgnPstdPreHrcut() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (initlMrgnPstdPreHrcut!=null) {
				result = initlMrgnPstdPreHrcut;
			}
			else {
				result = initlMrgnPstdPreHrcut = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getInitlMrgnPstdPstHrcut() {
			return initlMrgnPstdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateInitlMrgnPstdPstHrcut() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (initlMrgnPstdPstHrcut!=null) {
				result = initlMrgnPstdPstHrcut;
			}
			else {
				result = initlMrgnPstdPstHrcut = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getVartnMrgnPstdPreHrcut() {
			return vartnMrgnPstdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateVartnMrgnPstdPreHrcut() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (vartnMrgnPstdPreHrcut!=null) {
				result = vartnMrgnPstdPreHrcut;
			}
			else {
				result = vartnMrgnPstdPreHrcut = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getVartnMrgnPstdPstHrcut() {
			return vartnMrgnPstdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateVartnMrgnPstdPstHrcut() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (vartnMrgnPstdPstHrcut!=null) {
				result = vartnMrgnPstdPstHrcut;
			}
			else {
				result = vartnMrgnPstdPstHrcut = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("xcssCollPstd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xcssCollPstd")
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getXcssCollPstd() {
			return xcssCollPstd;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder getOrCreateXcssCollPstd() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder result;
			if (xcssCollPstd!=null) {
				result = xcssCollPstd;
			}
			else {
				result = xcssCollPstd = ActiveOrHistoricCurrencyAnd20DecimalAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setInitlMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount _initlMrgnPstdPreHrcut) {
			this.initlMrgnPstdPreHrcut = _initlMrgnPstdPreHrcut == null ? null : _initlMrgnPstdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setInitlMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount _initlMrgnPstdPstHrcut) {
			this.initlMrgnPstdPstHrcut = _initlMrgnPstdPstHrcut == null ? null : _initlMrgnPstdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setVartnMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount _vartnMrgnPstdPreHrcut) {
			this.vartnMrgnPstdPreHrcut = _vartnMrgnPstdPreHrcut == null ? null : _vartnMrgnPstdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnPstdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnPstdPstHrcut")
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setVartnMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd20DecimalAmount _vartnMrgnPstdPstHrcut) {
			this.vartnMrgnPstdPstHrcut = _vartnMrgnPstdPstHrcut == null ? null : _vartnMrgnPstdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("xcssCollPstd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("xcssCollPstd")
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder setXcssCollPstd(ActiveOrHistoricCurrencyAnd20DecimalAmount _xcssCollPstd) {
			this.xcssCollPstd = _xcssCollPstd == null ? null : _xcssCollPstd.toBuilder();
			return this;
		}
		
		@Override
		public PostedMarginOrCollateral6 build() {
			return new PostedMarginOrCollateral6.PostedMarginOrCollateral6Impl(this);
		}
		
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder prune() {
			if (initlMrgnPstdPreHrcut!=null && !initlMrgnPstdPreHrcut.prune().hasData()) initlMrgnPstdPreHrcut = null;
			if (initlMrgnPstdPstHrcut!=null && !initlMrgnPstdPstHrcut.prune().hasData()) initlMrgnPstdPstHrcut = null;
			if (vartnMrgnPstdPreHrcut!=null && !vartnMrgnPstdPreHrcut.prune().hasData()) vartnMrgnPstdPreHrcut = null;
			if (vartnMrgnPstdPstHrcut!=null && !vartnMrgnPstdPstHrcut.prune().hasData()) vartnMrgnPstdPstHrcut = null;
			if (xcssCollPstd!=null && !xcssCollPstd.prune().hasData()) xcssCollPstd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitlMrgnPstdPreHrcut()!=null && getInitlMrgnPstdPreHrcut().hasData()) return true;
			if (getInitlMrgnPstdPstHrcut()!=null && getInitlMrgnPstdPstHrcut().hasData()) return true;
			if (getVartnMrgnPstdPreHrcut()!=null && getVartnMrgnPstdPreHrcut().hasData()) return true;
			if (getVartnMrgnPstdPstHrcut()!=null && getVartnMrgnPstdPstHrcut().hasData()) return true;
			if (getXcssCollPstd()!=null && getXcssCollPstd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder o = (PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder) other;
			
			merger.mergeRosetta(getInitlMrgnPstdPreHrcut(), o.getInitlMrgnPstdPreHrcut(), this::setInitlMrgnPstdPreHrcut);
			merger.mergeRosetta(getInitlMrgnPstdPstHrcut(), o.getInitlMrgnPstdPstHrcut(), this::setInitlMrgnPstdPstHrcut);
			merger.mergeRosetta(getVartnMrgnPstdPreHrcut(), o.getVartnMrgnPstdPreHrcut(), this::setVartnMrgnPstdPreHrcut);
			merger.mergeRosetta(getVartnMrgnPstdPstHrcut(), o.getVartnMrgnPstdPstHrcut(), this::setVartnMrgnPstdPstHrcut);
			merger.mergeRosetta(getXcssCollPstd(), o.getXcssCollPstd(), this::setXcssCollPstd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedMarginOrCollateral6 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPstdPreHrcut, _that.getInitlMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(initlMrgnPstdPstHrcut, _that.getInitlMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPreHrcut, _that.getVartnMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPstHrcut, _that.getVartnMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(xcssCollPstd, _that.getXcssCollPstd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPstdPreHrcut != null ? initlMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (initlMrgnPstdPstHrcut != null ? initlMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPreHrcut != null ? vartnMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPstHrcut != null ? vartnMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (xcssCollPstd != null ? xcssCollPstd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedMarginOrCollateral6Builder {" +
				"initlMrgnPstdPreHrcut=" + this.initlMrgnPstdPreHrcut + ", " +
				"initlMrgnPstdPstHrcut=" + this.initlMrgnPstdPstHrcut + ", " +
				"vartnMrgnPstdPreHrcut=" + this.vartnMrgnPstdPreHrcut + ", " +
				"vartnMrgnPstdPstHrcut=" + this.vartnMrgnPstdPstHrcut + ", " +
				"xcssCollPstd=" + this.xcssCollPstd +
			'}';
		}
	}
}
