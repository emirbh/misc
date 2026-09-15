package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.TradeConfirmation4ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeConfirmation4Choice", builder=TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeConfirmation4Choice", model="iso20022", builder=TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilderImpl.class, version="${project.version}")
public interface TradeConfirmation4Choice extends RosettaModelObject {

	TradeConfirmation4ChoiceMeta metaData = new TradeConfirmation4ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	TradeConfirmation5 getConfd();
	TradeNonConfirmation1 getNonConfd();

	/*********************** Build Methods  ***********************/
	TradeConfirmation4Choice build();
	
	TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder toBuilder();
	
	static TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder builder() {
		return new TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeConfirmation4Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeConfirmation4Choice> getType() {
		return TradeConfirmation4Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("confd"), processor, TradeConfirmation5.class, getConfd());
		processRosetta(path.newSubPath("nonConfd"), processor, TradeNonConfirmation1.class, getNonConfd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeConfirmation4ChoiceBuilder extends TradeConfirmation4Choice, RosettaModelObjectBuilder {
		TradeConfirmation5.TradeConfirmation5Builder getOrCreateConfd();
		@Override
		TradeConfirmation5.TradeConfirmation5Builder getConfd();
		TradeNonConfirmation1.TradeNonConfirmation1Builder getOrCreateNonConfd();
		@Override
		TradeNonConfirmation1.TradeNonConfirmation1Builder getNonConfd();
		TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder setConfd(TradeConfirmation5 confd);
		TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder setNonConfd(TradeNonConfirmation1 nonConfd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("confd"), processor, TradeConfirmation5.TradeConfirmation5Builder.class, getConfd());
			processRosetta(path.newSubPath("nonConfd"), processor, TradeNonConfirmation1.TradeNonConfirmation1Builder.class, getNonConfd());
		}
		

		TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeConfirmation4Choice  ***********************/
	class TradeConfirmation4ChoiceImpl implements TradeConfirmation4Choice {
		private final TradeConfirmation5 confd;
		private final TradeNonConfirmation1 nonConfd;
		
		protected TradeConfirmation4ChoiceImpl(TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder builder) {
			this.confd = ofNullable(builder.getConfd()).map(f->f.build()).orElse(null);
			this.nonConfd = ofNullable(builder.getNonConfd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("confd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confd")
		public TradeConfirmation5 getConfd() {
			return confd;
		}
		
		@Override
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonConfd")
		public TradeNonConfirmation1 getNonConfd() {
			return nonConfd;
		}
		
		@Override
		public TradeConfirmation4Choice build() {
			return this;
		}
		
		@Override
		public TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder toBuilder() {
			TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder builder) {
			ofNullable(getConfd()).ifPresent(builder::setConfd);
			ofNullable(getNonConfd()).ifPresent(builder::setNonConfd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation4Choice _that = getType().cast(o);
		
			if (!Objects.equals(confd, _that.getConfd())) return false;
			if (!Objects.equals(nonConfd, _that.getNonConfd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (confd != null ? confd.hashCode() : 0);
			_result = 31 * _result + (nonConfd != null ? nonConfd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation4Choice {" +
				"confd=" + this.confd + ", " +
				"nonConfd=" + this.nonConfd +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeConfirmation4Choice  ***********************/
	class TradeConfirmation4ChoiceBuilderImpl implements TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder {
	
		protected TradeConfirmation5.TradeConfirmation5Builder confd;
		protected TradeNonConfirmation1.TradeNonConfirmation1Builder nonConfd;
		
		@Override
		@RosettaAttribute("confd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confd")
		public TradeConfirmation5.TradeConfirmation5Builder getConfd() {
			return confd;
		}
		
		@Override
		public TradeConfirmation5.TradeConfirmation5Builder getOrCreateConfd() {
			TradeConfirmation5.TradeConfirmation5Builder result;
			if (confd!=null) {
				result = confd;
			}
			else {
				result = confd = TradeConfirmation5.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonConfd")
		public TradeNonConfirmation1.TradeNonConfirmation1Builder getNonConfd() {
			return nonConfd;
		}
		
		@Override
		public TradeNonConfirmation1.TradeNonConfirmation1Builder getOrCreateNonConfd() {
			TradeNonConfirmation1.TradeNonConfirmation1Builder result;
			if (nonConfd!=null) {
				result = nonConfd;
			}
			else {
				result = nonConfd = TradeNonConfirmation1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("confd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confd")
		@Override
		public TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder setConfd(TradeConfirmation5 _confd) {
			this.confd = _confd == null ? null : _confd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonConfd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonConfd")
		@Override
		public TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder setNonConfd(TradeNonConfirmation1 _nonConfd) {
			this.nonConfd = _nonConfd == null ? null : _nonConfd.toBuilder();
			return this;
		}
		
		@Override
		public TradeConfirmation4Choice build() {
			return new TradeConfirmation4Choice.TradeConfirmation4ChoiceImpl(this);
		}
		
		@Override
		public TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder prune() {
			if (confd!=null && !confd.prune().hasData()) confd = null;
			if (nonConfd!=null && !nonConfd.prune().hasData()) nonConfd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConfd()!=null && getConfd().hasData()) return true;
			if (getNonConfd()!=null && getNonConfd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder o = (TradeConfirmation4Choice.TradeConfirmation4ChoiceBuilder) other;
			
			merger.mergeRosetta(getConfd(), o.getConfd(), this::setConfd);
			merger.mergeRosetta(getNonConfd(), o.getNonConfd(), this::setNonConfd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation4Choice _that = getType().cast(o);
		
			if (!Objects.equals(confd, _that.getConfd())) return false;
			if (!Objects.equals(nonConfd, _that.getNonConfd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (confd != null ? confd.hashCode() : 0);
			_result = 31 * _result + (nonConfd != null ? nonConfd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeConfirmation4ChoiceBuilder {" +
				"confd=" + this.confd + ", " +
				"nonConfd=" + this.nonConfd +
			'}';
		}
	}
}
